package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> adaugareLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvRezultat = findViewById(R.id.tvRezultat);
        Button btnAdauga = findViewById(R.id.btnAdaugaMuzeu);

        adaugareLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        MuzeuMaritim muzeu = (MuzeuMaritim) result.getData().getSerializableExtra("muzeu");
                        if (muzeu != null) {
                            tvRezultat.setText(muzeu.toString());
                            Toast.makeText(this, "Muzeu adăugat cu succes!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        btnAdauga.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdaugareMuzeuActivity.class);
            adaugareLauncher.launch(intent);
        });
    }
}