package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ListenerActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSample;

//    Logging in Android
    public static final String TAG = "ListenerActivity";

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view){

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);
        btnSample = findViewById(R.id.btnSample);

        btnSample.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //code
            }
        });

        btnSample.setOnClickListener(listener);

        btnSample.setOnClickListener(new CustomListener());
    }

    @Override
    public void onClick(View view){
        //
    }

    class CustomListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Log.d(TAG, "This is my log entry."); // d stands for debug

        }
    }

}