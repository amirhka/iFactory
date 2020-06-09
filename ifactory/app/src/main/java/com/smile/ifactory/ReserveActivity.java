package com.smile.ifactory;

import androidx.appcompat.app.AppCompatActivity;
import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReserveActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private PersianDatePickerDialog buttonDatePicker;
    List<String> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //show back button
        getSupportActionBar().setTitle("نوبت دهی");


        Spinner spinnerPlace = findViewById(R.id.spinnerPlacePickerReserveActivity);
        places = new ArrayList<>();
        places.add("ورکشاپ");
        places.add("آمفی تئاتر");
        places.add("کافی شاپ");
        places.add("لابراتوری");
        places.add("کتابخانه");

        ArrayAdapter<String> placeAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, places);
        placeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlace.setAdapter(placeAdapter);
        spinnerPlace.setOnItemSelectedListener(this);
    }


    public void showCalendar(View view) {

        buttonDatePicker = new PersianDatePickerDialog(this)
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1398)
                .setMaxYear(1400)
                .setActionTextColor(Color.GRAY)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        Toast.makeText(ReserveActivity.this, persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed() {

                    }
                });

        buttonDatePicker.show();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
