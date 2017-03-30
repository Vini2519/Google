package com.BmCollege.app.About;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.BmCollege.app.R;

public class About_Us extends AppCompatActivity {
    private ImageButton mission,profile,prin,board,facility,busroute,campus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);

        mission=(ImageButton) findViewById(R.id.mission);
        profile=(ImageButton) findViewById(R.id.profile);
        prin=(ImageButton) findViewById(R.id.prin);
        board=(ImageButton) findViewById(R.id.board);
        facility=(ImageButton) findViewById(R.id.facility);
        busroute=(ImageButton) findViewById(R.id.busroute);
        campus=(ImageButton) findViewById(R.id.campus);

        mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_Us.this,About_mission_vision.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_Us.this,About_director_profile.class);
                startActivity(intent);
            }
        });
        prin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_Us.this,About_princ_profile.class);
                startActivity(intent);
            }
        });
        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_Us.this,About_boards_of_govern.class);
                startActivity(intent);
            }
        });
        facility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_Us.this,About_facilities.class);
                startActivity(intent);
            }
        });
        busroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_Us.this,About_bus_route.class);
                startActivity(intent);
            }
        });
        campus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_Us.this,About_campus.class);
                startActivity(intent);
            }
        });

    }
}
