package com.smile.ifactory;

        import android.os.Bundle;

        import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //show back button
        getSupportActionBar().setTitle("پروفایل");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
