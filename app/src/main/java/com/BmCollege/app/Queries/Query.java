package com.BmCollege.app.Queries;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.BmCollege.app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Query extends AppCompatActivity {

    private AutoCompleteTextView textName, address, city, state, number, query,email;
    private Button submit;

    private DatabaseReference mDataBaseUsers;
    private FirebaseAuth mAuth;
    private ProgressDialog mprogress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        mDataBaseUsers = FirebaseDatabase.getInstance().getReference().child("Query");

        mAuth = FirebaseAuth.getInstance();

        mprogress = new ProgressDialog(this);

        textName = (AutoCompleteTextView) findViewById(R.id.textName);
        address = (AutoCompleteTextView) findViewById(R.id.address);
        city = (AutoCompleteTextView) findViewById(R.id.city);
        state = (AutoCompleteTextView) findViewById(R.id.state);
        number = (AutoCompleteTextView) findViewById(R.id.number);
        query = (AutoCompleteTextView) findViewById(R.id.query);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSetupAccount();
            }
        });
    }

    private void startSetupAccount() {

        final String text1 = textName.getText().toString().trim();
        final String text2 = address.getText().toString().trim();
        final String text3 = city.getText().toString().trim();
        final String text4 = state.getText().toString().trim();
        final String text5 = number.getText().toString().trim();
        final String text6 = query.getText().toString().trim();

        if (CheckNetwork.isInternetAvailable(Query.this)) {

            if (!TextUtils.isEmpty(text1) && !TextUtils.isEmpty(text2) && !TextUtils.isEmpty(text3) && !TextUtils.isEmpty(text4) && !TextUtils.isEmpty(text5) && !TextUtils.isEmpty(text6)) {

                mprogress.setMessage("Finishing...");
                mprogress.show();
                try {

                    Query_class blog = new Query_class(text1, text2, text3, text4, text5, text6);
                    FirebaseUser user = mAuth.getCurrentUser();

                    mDataBaseUsers.child(user.getUid()).setValue(blog);
                    mprogress.dismiss();

                    Toast.makeText(this, "Your query is Successfully submitted", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    mprogress.dismiss();
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();

            }
        } else {
            mprogress.dismiss();
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();

        }
    }

    public static class CheckNetwork {

        private static final String TAG = Query.CheckNetwork.class.getSimpleName();

        public static boolean isInternetAvailable(Context context) {
            NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

            if (info == null) {
                Log.d(TAG, "no internet connection");
                return false;
            } else {
                if (info.isConnected()) {
                    Log.d(TAG, " internet connection available...");
                    return true;
                } else {
                    Log.d(TAG, " internet connection");
                    return true;
                }

            }
        }
    }
}
