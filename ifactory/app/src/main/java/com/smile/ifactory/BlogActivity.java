package com.smile.ifactory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //show back button
        getSupportActionBar().setTitle("بلاگ");

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
