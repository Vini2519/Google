package com.BmCollege.app.Department;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.BmCollege.app.R;

public class Departments extends AppCompatActivity {

    private ImageButton cse,civil,ece,mech,mba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        cse=(ImageButton) findViewById(R.id.cse);
        civil=(ImageButton) findViewById(R.id.civil);
        ece=(ImageButton) findViewById(R.id.ece);
        mech=(ImageButton) findViewById(R.id.mech);
        mba=(ImageButton) findViewById(R.id.mba);

        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Departments.this,Departments_cse.class);
                startActivity(intent);
            }
        });
        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Departments.this,Departments_civil.class);
                startActivity(intent);
            }
        });
        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Departments.this,Departments_ece.class);
                startActivity(intent);
            }
        });
        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Departments.this,Departments_mech.class);
                startActivity(intent);
            }
        });
        mba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Departments.this,Departments_mba.class);
                startActivity(intent);
            }
        });
    }
}
