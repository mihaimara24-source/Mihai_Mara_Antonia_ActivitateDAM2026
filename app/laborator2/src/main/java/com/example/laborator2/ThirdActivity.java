package com.example.laborator2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private int val1 = 0;
    private int val2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bundlePrimit = getIntent().getExtras();

        if (bundlePrimit != null) {
            String mesaj = bundlePrimit.getString("cheie_mesaj");
            val1 = bundlePrimit.getInt("numar1", 0);
            val2 = bundlePrimit.getInt("numar2", 0);

            Log.i("ThirdActivity", "Mesaj primit: " + mesaj + " | Valori: " + val1 + ", " + val2);
            Toast.makeText(this, mesaj + " (" + val1 + ", " + val2 + ")", Toast.LENGTH_LONG).show();
        }

        Button btnSendBack = findViewById(R.id.btnSendBack);
        btnSendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int suma = val1 + val2;
                
                Intent resultIntent = new Intent();
                Bundle resultBundle = new Bundle();
                resultBundle.putString("mesaj_raspuns", "Calcul efectuat cu succes!");
                resultBundle.putInt("suma_valori", suma);
                resultIntent.putExtras(resultBundle);
                
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}