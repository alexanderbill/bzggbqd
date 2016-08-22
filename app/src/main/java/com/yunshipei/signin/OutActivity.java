package com.yunshipei.signin;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ubuntu on 16-8-1.
 */
public class OutActivity extends AppCompatActivity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);

        mEditText = (EditText)findViewById(R.id.dates);
        findViewById(R.id.datepicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mycalendar = Calendar.getInstance(Locale.CHINA);
                Date mydate = new Date(); //获取当前日期Date对象
                mycalendar.setTime(mydate);////为Calendar对象设置时间为当前日期

                int year = mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
                int month = mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
                final int day = mycalendar.get(Calendar.DAY_OF_MONTH);//获取Calendar对象中的月
                DatePickerDialog dialog = new DatePickerDialog(OutActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.format("%s-%s-%s", year, monthOfYear, dayOfMonth);
                        mEditText.setText(mEditText.getText() + date + "\n");
                    }
                }, year, month, day);
                dialog.show();
            }
        });

        findViewById(R.id.export).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }
}
