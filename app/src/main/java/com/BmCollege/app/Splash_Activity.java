package com.BmCollege.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.BmCollege.app.SignIn.GoogleSignInActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Splash_Activity extends AppCompatActivity {

    SharedPreferences preferences;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_bmiet);
        preferences = getSharedPreferences("FIRST", MODE_PRIVATE);

        mAuth = FirebaseAuth.getInstance();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent intent = new Intent(getApplicationContext(), GoogleSignInActivity.class);
                    if (preferences.getBoolean("first time user", true)) {
                        intent = new Intent(getApplicationContext(), Intro_Activity.class);
                    } else if (mAuth.getCurrentUser() != null)
                        intent = new Intent(Splash_Activity.this, Navigation_Activity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }

}
