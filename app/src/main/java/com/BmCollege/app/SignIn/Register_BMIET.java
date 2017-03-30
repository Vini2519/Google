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

import com.BmCollege.app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_BMIET extends AppCompatActivity implements View.OnClickListener {
    private EditText remail;
    private EditText rpassword;
    private Button login_in_button;
    private TextView text2;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__bmiet);

        mAuth= FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(Register_BMIET.this,Login_BMIET.class));

        }

        progressDialog=new ProgressDialog(this);


        remail=(EditText)findViewById(R.id.remail);
        rpassword=(EditText)findViewById(R.id.rpassword);
        login_in_button=(Button)findViewById(R.id.login_in_button);
        text2=(TextView)findViewById(R.id.text2);

        login_in_button.setOnClickListener(this);
        text2.setOnClickListener(this);

    }
    public static class CheckNetwork {

        private static final String TAGS = Register_BMIET.CheckNetwork.class.getSimpleName();

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
    private void registeruser(){

        String email= remail.getText().toString().trim();
        String password=rpassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){

            Toast.makeText(this,"Please enter Email!",Toast.LENGTH_SHORT).show();
            return;
        }if (TextUtils.isEmpty(password)){

            Toast.makeText(this,"Please enter Password!",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering User Please wait...");
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(CheckNetwork.isInternetAvailable(Register_BMIET.this)) //returns true if internet available
                {
                if (task.isSuccessful()) {
                    Toast.makeText(Register_BMIET.this, "Successfully Regestered", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(Register_BMIET.this,Login_BMIET.class));
                } else {
                    Toast.makeText(Register_BMIET.this, "Regestering failed please try again!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Register_BMIET.this, "Please Enter Unique Email and Password!", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }else {
                    progressDialog.dismiss();
                    Toast.makeText(Register_BMIET.this,"No Internet Connection",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view==login_in_button){
            registeruser();
        }
        if (view==text2){
            finish();
            startActivity(new Intent(this,Login_BMIET.class));

        }

    }
}
