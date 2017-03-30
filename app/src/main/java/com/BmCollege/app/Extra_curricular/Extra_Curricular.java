package com.BmCollege.app.Extra_curricular;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.BmCollege.app.R;

public class Extra_Curricular extends AppCompatActivity {

    private ImageButton fest,tour,sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra__curricular);

        fest=(ImageButton) findViewById(R.id.fest);
        tour=(ImageButton) findViewById(R.id.tour);
        sport=(ImageButton) findViewById(R.id.sport);

        fest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Extra_Curricular.this,Extra_cultural.class);
                startActivity(intent);

            }
        });
        tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Extra_Curricular.this,Extra_industrial.class);
                startActivity(intent);

            }
        });
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Extra_Curricular.this,Extra_sports.class);
                startActivity(intent);

            }
        });
    }
}
