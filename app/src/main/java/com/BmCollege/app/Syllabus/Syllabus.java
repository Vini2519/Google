package com.BmCollege.app.Syllabus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.BmCollege.app.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Syllabus extends AppCompatActivity {

    private Button first, eee, ece, civil, mech, mba, bca, bba, cse, cse4, cse5, cse6, cse7, cse8;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<SyllabusFirebaseModel, SyllabusFirebaseViewHolder> firebaseRecyclerAdapter3;
    RecyclerView recyclerView3;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        first = (Button) findViewById(R.id.first);
        cse = (Button) findViewById(R.id.cse);
        eee = (Button) findViewById(R.id.eee);
        ece = (Button) findViewById(R.id.ece);
        civil = (Button) findViewById(R.id.civil);
        mech = (Button) findViewById(R.id.mech);
        mba = (Button) findViewById(R.id.mba);
        bca = (Button) findViewById(R.id.bca);
        bba = (Button) findViewById(R.id.bba);
        cse4 = (Button) findViewById(R.id.cse4);
        cse5 = (Button) findViewById(R.id.cse5);
        cse6 = (Button) findViewById(R.id.cse6);
        cse7 = (Button) findViewById(R.id.cse7);
        cse8 = (Button) findViewById(R.id.cse8);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        recyclerView3 = (RecyclerView) findViewById(R.id.recycler_view3);
        recyclerView3.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView3.setLayoutManager(layoutManager);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseRecyclerAdapter3 = new FirebaseRecyclerAdapter<SyllabusFirebaseModel, SyllabusFirebaseViewHolder>(
                SyllabusFirebaseModel.class,
                R.layout.dynamic_syllabus,
                SyllabusFirebaseViewHolder.class,
                databaseReference.child("Assignments").getRef()
        ) {
            @Override
            protected void populateViewHolder(SyllabusFirebaseViewHolder viewHolder, final SyllabusFirebaseModel model, int position) {
                viewHolder.text.setText(model.getTitles());
                progressBar.setVisibility(View.GONE);

                if (model.getImages().equals("")) {
                    viewHolder.image.setVisibility(View.GONE);
                } else {
                    Picasso.with(getApplicationContext()).load(model.getImages()).into(viewHolder.image);
                    viewHolder.image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(model.getImages()));
                            startActivity(intent);
                        }
                    });
                }
                if (model.getLink().equals("")) {
                    viewHolder.file_url.setVisibility(View.GONE);
                } else {
                    viewHolder.file_url.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(model.getLink()));
                            startActivity(intent);
                        }
                    });
                }
            }
        };

        recyclerView3.setAdapter(firebaseRecyclerAdapter3);

        firebaseRecyclerAdapter3.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int friendlyMessageCount = firebaseRecyclerAdapter3.getItemCount();
                int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();
                if (lastVisiblePosition == -1 || (positionStart >= (friendlyMessageCount - 1) && lastVisiblePosition == (positionStart - 1))) {
                    recyclerView3.scrollToPosition(positionStart);
                }
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/BmCollegeapp.appspot.com/o/Syllabus%2F1Final%20Scheme%20%26%20Syllabus-%20Ist%20%26%202nd%20Semester%20for%20the%20academic%20session%202014-15.pdf?alt=media&token=204c2bde-a96f-4cf1-99d9-90ddb210a4e8"));
                startActivity(intent);
            }
        });

        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/BmCollegeapp.appspot.com/o/Syllabus%2FCse3rd%20sem.pdf?alt=media&token=8cd9fc65-7163-41cf-853c-4434d0fc4587"));
                startActivity(intent);

            }
        });

        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/BmCollegeapp.appspot.com/o/Syllabus%2FRevised-B.Tech_.-Electrical-Electronics-Engg.-2013.pdf?alt=media&token=82e2480e-d997-44fd-bfbb-a5e316af9e4e"));
                startActivity(intent);

            }
        });

        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/BmCollegeapp.appspot.com/o/Syllabus%2FB_Tech-ECE-revised-July-16.pdf?alt=media&token=25a0de06-ab54-4b0c-83c4-120f6e588f0d"));
                startActivity(intent);

            }
        });

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/BmCollegeapp.appspot.com/o/Syllabus%2FRevised-B-TECH-Civil-Engg.pdf?alt=media&token=4fa01ed3-979b-43a2-9a74-1a3a2f329a15"));
                startActivity(intent);

            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/BmCollegeapp.appspot.com/o/Syllabus%2FRevised-B.-TECH-Mech.-Engg.-2013.pdf?alt=media&token=fda7288c-15a2-42fd-a048-b895b796050c"));
                startActivity(intent);

            }
        });

        mba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/BmCollegeapp.appspot.com/o/Syllabus%2FMBA260710.pdf?alt=media&token=4e740ef0-621b-433d-96b8-c67243f0f358"));
                startActivity(intent);

            }
        });

        bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/Bmietapp.appspot.com/o/Syllabus%2FBCAsyllbca191011.pdf?alt=media&token=38d3b0ba-f169-4c63-8746-35531bc6126f"));
                startActivity(intent);

            }
        });

        bba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/Bmietapp.appspot.com/o/Syllabus%2Fbba121011.pdf?alt=media&token=6a5b5060-b754-4e55-a423-9f6e71e0adb3"));
                startActivity(intent);

            }
        });

        cse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/Bmietapp.appspot.com/o/Syllabus%2FCse4th%20sem.pdf?alt=media&token=f337df6c-3b89-4e13-8a33-657312385b3e"));
                startActivity(intent);
            }
        });

        cse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/Bmietapp.appspot.com/o/Syllabus%2FCse5th%20sem.pdf?alt=media&token=97d7108f-7b89-4a38-9ddd-c4d370927456"));
                startActivity(intent);
            }
        });

        cse6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/Bmietapp.appspot.com/o/Syllabus%2FCse6th%20sem.pdf?alt=media&token=8a1c0071-1038-4dee-985e-50b3d6d74294"));
                startActivity(intent);

            }
        });

        cse7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/mietapp.appspot.com/o/Syllabus%2FCse7th%20sem.pdf?alt=media&token=8fcc1e83-f4ff-4f03-935d-265536191b55"));
                startActivity(intent);

            }
        });

        cse8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/bmietapp.appspot.com/o/Syllabus%2FCse8th%20sem.pdf?alt=media&token=f1cd2dce-be36-44c7-a141-84e9e8be67e5"));
                startActivity(intent);

            }
        });
    }
}
