package com.example.samplecode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

public class DateActivity extends AppCompatActivity {

    EditText txtSelectedDate;
    Button btnShowDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        txtSelectedDate = findViewById(R.id.txtSelectedDate);
        btnShowDatePicker = findViewById(R.id.btnShowDatePicker);

        btnShowDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
    }

    private void showDatePicker(){
        Date today = new Date();
        int year = today.getYear() + 1900;
        int month = today.getMonth();
        int day = today.getDay();
        DatePickerDialog dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                String selectedDate = (m + 1) + "/" + d + "/" + y;
                txtSelectedDate.setText(selectedDate);
             //   datePicker.dismiss();
            }
        }, year, month, day);
        dp.show();
    }
}