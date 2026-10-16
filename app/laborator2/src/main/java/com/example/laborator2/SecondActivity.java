package com.example.laborator2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> thirdActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        thirdActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle rez = result.getData().getExtras();
                        if (rez != null) {
                            String mesaj = rez.getString("mesaj_raspuns", "");
                            int suma = rez.getInt("suma_valori", 0);
                            
                            Toast.makeText(SecondActivity.this, 
                                "Mesaj: " + mesaj + "\nSuma: " + suma, 
                                Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        Button btnOpen = findViewById(R.id.btnOpenThird);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("cheie_mesaj", "Salut din a doua activitate!");
                bundle.putInt("numar1", 10);
                bundle.putInt("numar2", 42);

                intent.putExtras(bundle);

                thirdActivityLauncher.launch(intent);
            }
        });
    }
}