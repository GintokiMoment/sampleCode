package com.example.samplecode;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.Date;

public class LifeCycleActivity extends AppCompatActivity {

    public static final String TAG = "LifeCycleActivity";
    Button btnMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d(TAG, "onCreate() is running....");
        btnMain = findViewById(R.id.btnMain);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LifeCycleActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        // https://tanzu.vmware.com/content/blog/android-savedinstancestate-bundle-faq
        if(savedInstanceState != null){
            long timeStamp = savedInstanceState.getLong("TIMESTAMP_KEY");
            Date d = new Date(timeStamp);
            Log.d(TAG, "Restoring data from " + d.toString());
        }
    }



    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() is running...RESTORE ANY DATA HERE");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() is running...");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() is running...SAVE YOUR DATA HERE");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() is running...");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy() is running...");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        Log.d(TAG, "onSaveInstanceState() is running....");
        super.onSaveInstanceState(outState);
        long timeStamp = new Date().getTime();
        outState.putLong("TIMESTAMP_KEY", timeStamp);

    }
}