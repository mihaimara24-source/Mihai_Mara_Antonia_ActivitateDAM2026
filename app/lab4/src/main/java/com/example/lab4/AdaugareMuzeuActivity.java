package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class AdaugareMuzeuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_muzeu);

        EditText etDenumire = findViewById(R.id.etDenumire);
        EditText etAn = findViewById(R.id.etAn);
        CheckBox cbGhid = findViewById(R.id.cbGhid);
        RadioGroup rgCategorie = findViewById(R.id.rgCategorie);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(v -> {
            MuzeuMaritim muzeu = new MuzeuMaritim();
            
            muzeu.setDenumire(etDenumire.getText().toString());
            
            try {
                muzeu.setAnInfiintare(Integer.parseInt(etAn.getText().toString()));
            } catch (NumberFormatException e) {
                muzeu.setAnInfiintare(0);
            }
            
            muzeu.setAreGhid(cbGhid.isChecked());
            
            int selectedId = rgCategorie.getCheckedRadioButtonId();
            if (selectedId == R.id.rbVIP) {
                muzeu.setCategorieBilet("VIP");
            } else {
                muzeu.setCategorieBilet("Standard");
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("muzeu", muzeu);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}