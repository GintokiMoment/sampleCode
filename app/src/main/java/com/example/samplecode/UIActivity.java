package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UIActivity extends AppCompatActivity {

    Button btnSomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiactivity);
        btnSomeButton = findViewById(R.id.btnSomeButton);
        btnSomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UIActivity.this, "Hiiii", Toast.LENGTH_LONG).show();
            }
        });

    }
}