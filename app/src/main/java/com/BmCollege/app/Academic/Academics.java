package com.BmCollege.app.Academic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.BmCollege.app.R;

public class Academics extends AppCompatActivity {

    private ImageButton course,library,document,eligible,fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics);

        course=(ImageButton) findViewById(R.id.course);
        library=(ImageButton) findViewById(R.id.library);
        document=(ImageButton) findViewById(R.id.document);
        fees=(ImageButton) findViewById(R.id.fees);
        eligible=(ImageButton) findViewById(R.id.eligible);

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Academics.this,Academics_course.class);
                startActivity(intent);
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Academics.this,Academics_library.class);
                startActivity(intent);
            }
        });
        document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Academics.this,Acadmic_document_req.class);
                startActivity(intent);
            }
        });
        fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Academics.this,Academics_Fees.class);
                startActivity(intent);
            }
        });
        eligible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Academics.this,Academics_eligibility.class);
                startActivity(intent);
            }
        });
    }
}
