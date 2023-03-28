package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentSenderActivity extends AppCompatActivity {

    public static final String TAG = "IntentSenderActivity: ";
    public static final String EXTRA_SOME_KEY = "zigmo";

    Button btnOpenUrl;
    EditText txtMessage;
    Button btnSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sender);

        Intent i = getIntent();
        String extraMessage = i.getStringExtra("SOME_KEY");
        if(extraMessage != null){
            Log.d(TAG, extraMessage);
        }

        btnOpenUrl = findViewById(R.id.btnOpenUrl);
        txtMessage = findViewById(R.id.txtMessage);
        btnSendMessage = findViewById(R.id.btnSendMessage);

        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
            }
        });

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = txtMessage.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(i);
//                When you launch an intent, the android os analyzes the intent and looks for any activity in the app that can match it inside the manifest file
                // Explicit intent means "ago to this activity" like intentlistner.class in button
                //implicit means you leave it up to os to figure out what options it has
            }
        });
    }
}