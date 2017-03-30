package com.BmCollege.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.BmCollege.app.SignIn.GoogleSignInActivity;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by Vineet Jain on 12/23/2016.
 */

public class Intro_Activity extends AppIntro {

    private static boolean doubleBackToExitPressedOnce;
    SharedPreferences preferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(AppIntroFragment.newInstance("", "", R.drawable.pic_3,
                ContextCompat.getColor(getApplicationContext(), R.color.slide1)));

        addSlide(AppIntroFragment.newInstance("", "", R.drawable.pic_2,
                ContextCompat.getColor(getApplicationContext(), R.color.slide2)));

        addSlide(AppIntroFragment.newInstance("", "", R.drawable.sss,
                ContextCompat.getColor(getApplicationContext(), R.color.slide3)));

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(this, GoogleSignInActivity.class));
        // Do something when users tap on Skip button.
        preferences = getSharedPreferences("FIRST", MODE_PRIVATE);
        preferences.edit().putBoolean("first time user", false).apply();
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(this, GoogleSignInActivity.class));
        preferences = getSharedPreferences("FIRST", MODE_PRIVATE);
        preferences.edit().putBoolean("first time user", false).apply();
        finish();
    }

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
