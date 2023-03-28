package com.example.samplecode;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

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

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HttpTaskDataAccess {
    static RequestQueue queue;
    public static final String URL = "https://www.wtc-web.com/volley-test.php";
    public static final String TAG = "HttpTaskDataAccess";
    Context context;
    public HttpTaskDataAccess(Context c){
        if(queue == null){
            queue = Volley.newRequestQueue(c);
        }
    }

    public void getAllTasks(HttpListener listener){
        // TODO: Make the http request

        // HTML POST / GET REQUEST
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
                Type type = new TypeToken<ArrayList<Task>>(){}.getType();
                ArrayList<Task> allTasks = gson.fromJson(response, type);
                listener.onDone(allTasks); //instead of passing in string, pass in the obj all tasks

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "ERROR" + error.getMessage());
            }
        });

        queue.add(stringRequest);

    }

    public interface  HttpListener{ //or "is the request done"
        public void onDone(Object o);

    }

    private boolean isNetAvailable(){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);//static context
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }

}
