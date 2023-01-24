package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonPressed (View v) {
        //Toast.makeText(this, "Helloooo", Toast.LENGTH_LONG).show();
        int idNumber = v.getId();
        String idName = getResources().getResourceEntryName(idNumber);
        //Toast.makeText(this, idName, Toast.LENGTH_LONG).show();

        Intent i;
//show how to go from one activity to another
//switch on ID NAME
        switch(idName){
            case "btnSample":
                i = new Intent(this, Test.class);
                startActivity(i);
                break;

            case "btnSpinnerActivity":
                i = new Intent(this, SpinnerActivity.class);
                startActivity(i);
                break;
        }
    }

}