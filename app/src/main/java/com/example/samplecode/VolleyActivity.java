package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.samplecode.models.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class VolleyActivity extends AppCompatActivity {

    Button btnGetAllTasks;
    public static final String URL = "https://www.wtc-web.com/volley-test.php";
    public static final String TAG = "VolleyActivity";
    RequestQueue queue;
    ArrayList<Task> allTasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        // TEST CODE ---------
        HttpTaskDataAccess da = new HttpTaskDataAccess(this);
        da.getAllTasks(new  HttpTaskDataAccess.HttpListener(){
            @Override
            public void onDone(Object o) {

            }
        });

        queue = Volley.newRequestQueue(this);
        btnGetAllTasks = findViewById(R.id.btnGetAllTasks);
        btnGetAllTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNetAvailable()) {
                    sendTestRequest();
                } else {
                    Toast.makeText(VolleyActivity.this,"Net Not Available", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean isNetAvailable(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//static context
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }

//    Test request... then it goes to string request, which is a listener.. then goes to Response.Error listener to handle any errors...
    private void sendTestRequest(){
        // HTML POST / GET REQUEST
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
                Type type = new TypeToken<ArrayList<Task>>(){}.getType();
                allTasks = gson.fromJson(response, type);
                Log.d(TAG, allTasks.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "ERROR" + error.getMessage());
            }
        });

        queue.add(stringRequest);
    }
}