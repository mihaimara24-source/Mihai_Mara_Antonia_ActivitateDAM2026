package com.example.laborator2;
import android.util.Log;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CiclulDeViata";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() apelat - DEBUG");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume() apelat - VERBOSE");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause() apelat - WARNING");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop() apelat - ERROR");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() apelat");
    }

    public void CulegeDate(View view) {
        EditText et=findViewById(R.id.nume_ET);
        CheckBox cb=findViewById(R.id.eStudent_CB);

        String nume=et.getText().toString();
        Boolean eStudent=cb.isChecked();
    }
}
