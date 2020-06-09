package com.smile.ifactory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //show back button
        getSupportActionBar().setTitle("ارسال تیکت");


        //NAVBAR
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navbarTicket);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Intent intentHome = new Intent(TicketActivity.this, UserControlActivity.class);
                        startActivity(intentHome);
                        break;
                    case R.id.action_call:
                        Intent intentCall = new Intent(TicketActivity.this, CallActivity.class);
                        startActivity(intentCall);
                        break;
                    case R.id.action_profile:
                        Intent intentProfile = new Intent(TicketActivity.this, ProfileActivity.class);
                        startActivity(intentProfile);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                return true;
            }
        });




    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void goToTicketSendActivity(View view) {
        Intent intentCall = new Intent(TicketActivity.this, TicketSendActivity.class);
        startActivity(intentCall);
    }

    public void goToTicketSentActivity(View view){
        Intent intentCall = new Intent(TicketActivity.this, TicketSentActivity.class );
        startActivity(intentCall);
    }
}
