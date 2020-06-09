package com.smile.ifactory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserControlActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    List<String> phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercontrol);


        //DATE
        PersianDate pdate = new PersianDate();
        PersianDateFormat pdformater2 = new PersianDateFormat("l, j F");
        pdformater2.format(pdate);
        TextView date = (TextView) findViewById(R.id.textViewDate);
        String dataStringDate = pdformater2.format(pdate);
        date.setText(dataStringDate);


        //clock
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = (TextView) findViewById(R.id.textViewTime);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                                String dataString = sdf.format(date);
                                tdate.setText(dataString);

                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();


        //NAVBAR
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navbarMain);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        break;
                    case R.id.action_call:
                        Intent intentCall = new Intent(UserControlActivity.this, CallActivity.class);
                        startActivity(intentCall);
                        break;
                    case R.id.action_profile:
                        Intent intentProfile = new Intent(UserControlActivity.this, ProfileActivity.class);
                        startActivity(intentProfile);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                return true;
            }
        });


        //SPINNER
        spinner = (Spinner) findViewById(R.id.spinner);

        phone = new ArrayList<>();

        phone.add("آخرین اخبار");
        phone.add("آموزش ساخت ربات مسیریاب آغاز شد!");
        phone.add("رونمایی از اپلیکیشن جدید کارخانه در آمفی تئاتر!");
        phone.add("با اعضای جدید کارخانه آشنا شوید!");
        phone.add("برگزاری مسابقات والیبال هر روز از ساعت 7 تا 9!");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, phone);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

    public void goToTicketActivity(View view) {
        Intent intentProfile = new Intent(UserControlActivity.this, TicketActivity.class);
        startActivity(intentProfile);
    }

    public void goToReserveActivity(View view) {
        Intent intent = new Intent(UserControlActivity.this, ReserveActivity.class);
        startActivity(intent);
    }

    public void goToBlogActivity(View view){
        Intent intent = new Intent(UserControlActivity.this , BlogActivity.class);
        startActivity(intent);
    }

}

