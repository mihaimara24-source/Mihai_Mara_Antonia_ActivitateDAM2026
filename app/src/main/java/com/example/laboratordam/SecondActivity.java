package com.example.laboratordam;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnOpen = findViewById(R.id.btnOpenThird);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Creăm Intent-ul către ThirdActivity
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

                // 2. Creăm Bundle-ul cu mesajul și 2 valori întregi
                Bundle bundle = new Bundle();
                bundle.putString("cheie_mesaj", "Salut din a doua activitate!");
                bundle.putInt("numar1", 10);
                bundle.putInt("numar2", 42);

                // 3. Atașăm Bundle-ul la Intent
                intent.putExtras(bundle);

                // 4. Pornim a treia activitate
                startActivity(intent);
            }
        });
    }
}