package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.samplecode.models.Task;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    ListView lsTasks;
    HttpTaskDataAccess da;
    ArrayList<Task> allTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        lsTasks = findViewById(R.id.lsTasks);

        da = new HttpTaskDataAccess(this);
        da.getAllTasks(new HttpTaskDataAccess.HttpListener() {
            @Override
            public void onDone(Object o) {
                allTasks = (ArrayList<Task>) o;
                setUpList();
            }
        });
    }

    private void setUpList(){
        ArrayAdapter<Task> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allTasks);
        lsTasks.setAdapter(adapter);
    }
}