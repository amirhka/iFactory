package com.smile.ifactory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TicketSentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_sent);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //show back button
        getSupportActionBar().setTitle("تیکت های ارسال شده");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
