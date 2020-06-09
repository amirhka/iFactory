package com.smile.ifactory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TicketSendActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    List<String> section;
    List<String> sendTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_send);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //show back button
        getSupportActionBar().setTitle("ارسال تیکت");


        Spinner spinnerSection = findViewById(R.id.spinnerSectionActivitySend);
        Spinner spinnerSubject = findViewById(R.id.spinnerSendToActivitySend);

        section = new ArrayList<>();
        section.add("مشکلات");
        section.add("انتقادات و پیشنهادات");
        section.add("درخواست");
        section.add("...");

        sendTo = new ArrayList<>();
        sendTo.add("مسئول فضای کار اشتراکی");
        sendTo.add("مسئول خوابگاه");
        sendTo.add("مسئول غذاخوری");
        sendTo.add("...");

        ArrayAdapter<String> sectionAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, section);
        sectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSection.setAdapter(sectionAdapter);
        spinnerSection.setOnItemSelectedListener(this);


        ArrayAdapter<String> sendToAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, sendTo);
        sendToAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(sendToAdapter);
        spinnerSubject.setOnItemSelectedListener(this);

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
