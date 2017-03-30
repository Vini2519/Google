package com.BmCollege.app.SignIn;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.BmCollege.app.Navigation_Activity;
import com.BmCollege.app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_BMIET extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LOGIN_BMIET";
    private EditText lemail;
    private EditText lpassword;
    private Button sign_in_button;
    private TextView text;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__bmiet);

        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        lemail = (EditText) findViewById(R.id.lemail);
        lpassword = (EditText) findViewById(R.id.lpassword);
        sign_in_button = (Button) findViewById(R.id.sign_in_button);
        text = (TextView) findViewById(R.id.text);

        sign_in_button.setOnClickListener(this);
        text.setOnClickListener(this);
    }

    private void userLogin() {

        String email = lemail.getText().toString().trim();
        String password = lpassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Please enter Email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {

            Toast.makeText(this, "Please enter Password!", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Login Please wait...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(Login_BMIET.CheckNetwork.isInternetAvailable(Login_BMIET.this)) //returns true if internet available
                {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(Login_BMIET.this, Navigation_Activity.class));
                    Login_BMIET.this.finish();
                } else {

                    Log.e(TAG, "Sign-in Failed: " + task.getException().getMessage());
                    Toast.makeText(Login_BMIET.this, "Login Faled:( Please try again!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Login_BMIET.this, "Inorrect Email or Password!", Toast.LENGTH_SHORT).show();
                }
            }else {
                    progressDialog.dismiss();
                    Toast.makeText(Login_BMIET.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
                }
            }
        });
        }


    @Override
    public void onClick(View view) {

        if (view == sign_in_button) {
            userLogin();
        }
        if (view == text) {
            finish();
            startActivity(new Intent(this, Register_BMIET.class));
        }

    }

    public static class CheckNetwork {

        private static final String TAGS = Login_BMIET.CheckNetwork.class.getSimpleName();

        public static boolean isInternetAvailable(Context context) {
            NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

            if (info == null) {
                Log.d(TAGS, "no internet connection");
                return false;
            } else {
                if (info.isConnected()) {
                    Log.d(TAGS, " internet connection available...");
                    return true;
                } else {
                    Log.d(TAGS, " internet connection");
                    return true;
                }

            }
        }
    }
}
