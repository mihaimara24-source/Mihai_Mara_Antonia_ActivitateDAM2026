package com.example.laboratordam;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Bundle bundlePrimit = getIntent().getExtras();

        if (bundlePrimit != null) {
            String mesaj = bundlePrimit.getString("cheie_mesaj");
            int val1 = bundlePrimit.getInt("numar1");
            int val2 = bundlePrimit.getInt("numar2");

            Log.i("ThirdActivity", "Mesaj primit: " + mesaj + " | Valori: " + val1 + ", " + val2);
            Toast.makeText(this, mesaj + " (" + val1 + ", " + val2 + ")", Toast.LENGTH_LONG).show();
        }
    }
}