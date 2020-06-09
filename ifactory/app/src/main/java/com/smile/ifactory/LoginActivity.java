package com.smile.ifactory;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {

    EditText usernameEdittext;
    EditText passwordEdittext;

    Dialog callDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        callDialog = new Dialog(this);

        usernameEdittext = (EditText) findViewById(R.id.editTextUsername);
        passwordEdittext = (EditText) findViewById(R.id.editTextPassword);

        final Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validating the log in data
                boolean validationError = false;

                StringBuilder validationErrorMessage = new StringBuilder("لطفا ");
                if (isEmpty(usernameEdittext)) {
                    validationError = true;
                    validationErrorMessage.append("نام کاربری");
                }
                if (isEmpty(passwordEdittext)) {
                    if (validationError) {
                        validationErrorMessage.append(" و ");
                    }
                    validationError = true;
                    validationErrorMessage.append("رمز عبور");
                }
                validationErrorMessage.append(" را وارد نمایید.");

                if (validationError) {
                    Toast.makeText(LoginActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG).show();
                    return;
                }

                //Setting up a progress dialog
                final ProgressDialog dlg = new ProgressDialog(LoginActivity.this);
                dlg.setTitle("لطفا صبر کنید");
                dlg.setMessage("در حال ورود...");
                dlg.show();

                ParseUser.logInInBackground(usernameEdittext.getText().toString(), passwordEdittext.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            Intent intent = new Intent(LoginActivity.this, UserControlActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        } else {
                            dlg.dismiss();
                            ParseUser.logOut();
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });




            }
        });

    }

    private boolean isEmpty(EditText text) {
        if (text.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void ShowPopUp(View view) {

        ImageView popupClose;
        Button btnFollow;
        callDialog.setContentView(R.layout.call_popup);
        popupClose =(ImageView) callDialog.findViewById(R.id.buttonClosePopUp);
        popupClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDialog.dismiss();
            }
        });
        Objects.requireNonNull(callDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        callDialog.show();

    }
}
