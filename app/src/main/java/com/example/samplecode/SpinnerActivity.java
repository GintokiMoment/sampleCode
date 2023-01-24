package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = findViewById(R.id.spinner);
        imgView = findViewById(R.id.imageView);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String selectedItem = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void changeImage(String selected){
        int resourceId = 0;
        switch (selected) {
            case "Happy Dog":
                resourceId = R.drawable.happy_dog;
                break;
            case "Angry Dog":
                resourceId = R.drawable.angry_dog;
                break;
            case "Puppies":
                resourceId = R.drawable.dog_with_puppies;
                break;
        }
        imgView.setImageResource(resourceId);

    }
}