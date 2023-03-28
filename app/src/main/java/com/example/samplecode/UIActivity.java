package com.example.samplecode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UIActivity extends AppCompatActivity {

    Button btnSomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiactivity);
/*
//    Get Resources

        String appName = getResources().getString(R.string.app_name);
        showToast(appName);
        String[] strings = getResources().getStringArray(R.array.spinner_data);
        showToast(strings[0]);


        btnSomeButton = findViewById(R.id.btnSomeButton);
        btnSomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UIActivity.this, "Hiiii", Toast.LENGTH_LONG).show();
            }
        });

        EditText etPlain = findViewById(R.id.etPlain);
        etPlain.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                showToast(etPlain.getText().toString());
                return false;
            }
        });

        CalendarView cvSomeDate = findViewById(R.id.cvSomeDate);
        cvSomeDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String msg = String.format("SELECTED DATE : %d/%d/%d", month + 1, dayOfMonth, year);
                showToast(msg);
            }

            CheckBox chkKetchup = findViewById(R.id.chkKetchup);
            CheckBox chkMustard = findViewById(R.id.chkMustard);

            View.OnClickListener toppingsListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String msg = "Toppings: ";
                    if (chkKetchup.isChecked()) {
                        msg += " Ketchup ";
                    }
                    if (chkMustard.isChecked()) {
                        msg += " Mustard";
                    }
                    showToast(msg);
                }
            };

//        chkKetchup.setOnClickListener(toppingsListener);


            ProgressBar progessBar = findViewById(R.id.progressBar);
            RadioGroup rgProgress = findViewById(R.id.rgProgress);

        rgProgress.setOnCheckedChangeListener(
            RadioGroup radioGroup, int checkedId){
                String checkedRadioName = getResources().getResourceEntryName(checkedId);
                showToast(checkedRadioName);
                if (checkedRadioName.equals("rbProgressOn")) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progessBar.setVisibility(View.GONE);
                }
            };


            private void showToast(String message) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }

 */
    }
}