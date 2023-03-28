package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.samplecode.fileio.FileHelper;
import com.example.samplecode.models.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileIOActivity extends AppCompatActivity {

    public static final String TAG = "FileIOActivity";
    public static final String LINE_DELIMITER = "\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_io);

//        Quick test on FILEHELPER
        boolean result = FileHelper.writeToFile("test.txt", "Hello World!", this);
        if (result){
            Log.d(TAG,"PASSED THE FIRST TEST!");
        } else {
            Log.d(TAG, "FAILED to writeToFile() did not succeed.");
        }

        String data = FileHelper.readFromFile("test.txt", this);
        if(data != null) {
            Log.d(TAG, "PASSED THE SECOND TEST!");
        } else {
            Log.d(TAG,  "Failed to readFromFile()");
        }

//        TEST CONVERT TO CSV
        Task t = new Task(1, "Mow the lawn", new Date(), false);
        String csv = convertTaskToCSV(t);
        Log.d(TAG, "Task CSV: " + csv);

//        TEST CONVERT TO TASK
        Task newTask = convertCSVToTask(csv);
        Log.d(TAG, "Task object: " + newTask.toString());

        final String TASKS_FILE = "tasks.csv";

        ArrayList<Task> taskList = new ArrayList<Task>() {{
            add(new Task(1, "Walk the dog", new Date(123, 6, 22), false));
            add(new Task(2, "Pay balances on credit card", new Date(123, 6, 22), false));
            add(new Task(3, "Go out to eat", new Date(123, 6, 22), true));
        }};

        String csvData = "";

        for (Task currentTask : taskList){
            csvData += convertTaskToCSV(currentTask) + "\n";
        }
        FileHelper.writeToFile(TASKS_FILE, csvData, this);

//        NEW TASK LIST, EMPTY TO WRITE CSV TO.

        ArrayList<Task> newList = new ArrayList<Task>();

        csvData = FileHelper.readFromFile(TASKS_FILE, this);
        Log.d(TAG, "onCreate: File contents: \n" + csvData);

        String[] lines = csvData.split(LINE_DELIMITER);

        for(String line : lines) {
            Task task = convertCSVToTask(line);
            if (task != null) {
                newList.add(task);
            }
        }

        Log.d(TAG, "ARRAY LIST: " + newList.toString());

    }
    private String convertTaskToCSV (Task task){

        String id = String.valueOf(task.getId());
        String description = task.getDescription();
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String dueDate = sdf.format(task.getDue());
        String isDone = String.valueOf(task.isDone());

        return String.format("%s,%s,%s,%s", id, description, dueDate, isDone);
    }

    private Task convertCSVToTask(String csvData){
        String[] csvParsed = csvData.split(",");
        long id = Long.parseLong(csvParsed[0]);
        String description = csvParsed[1];
        Date dueDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        try {
            dueDate = sdf.parse(csvParsed[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean done = Boolean.parseBoolean(csvParsed[3]);

        Task newTask = new Task(id, description, dueDate, done);
        return newTask;
    }
}