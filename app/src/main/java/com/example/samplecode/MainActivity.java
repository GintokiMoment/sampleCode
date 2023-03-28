package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.samplecode.models.Dog;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAIN ACTIVITY: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Dog d = new Dog();
//        Log.d(TAG, d.toString());

        for (Dog d : Dog.allDogs){
            Log.d(TAG, d.toString());
        }
// take for loop and put in diff activity and see if it will work..
        Dog.allDogs.add(new Dog(3, "Bubby", false));
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

            case "btnUIActivity":
                i = new Intent (this, UIActivity.class);
                startActivity(i);
                break;
            case "btnListenerActivity":
                i = new Intent (this, ListenerActivity.class);
                startActivity(i);
                break;
            case "btnIntentSenderActivity":
                i = new Intent (this, IntentSenderActivity.class);
                i.putExtra(IntentSenderActivity.EXTRA_SOME_KEY, "Hello There!"); //specify key and value, searching for hashmap inside i
                startActivity(i);
                break;
            case "btnLifeCycleActivity":
                i = new Intent (this, LifeCycleActivity.class);
                startActivity(i);
                break;
            case "btnFileIOActivity":
                i = new Intent (this, FileIOActivity.class);
                startActivity(i);
                break;
            case "btnAdapterActivity":
                i = new Intent (this, AdapterActivity.class);
                startActivity(i);
                break;
            case "btnDateActivity":
                i = new Intent (this, DateActivity.class);
                startActivity(i);
                break;
            case "btnVolleyActivity":
                i = new Intent (this, VolleyActivity.class);
                startActivity(i);
                break;
            case "btnTaskListActivity":
                i = new Intent (this, TaskListActivity.class);
                startActivity(i);
                break;
        }
    }

}