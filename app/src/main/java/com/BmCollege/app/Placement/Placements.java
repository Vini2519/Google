package com.BmCollege.app.Placement;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.BmCollege.app.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Placements extends AppCompatActivity {

    private ImageButton detail, recru, facilities;
    private ProgressBar progressBar;
    DatabaseReference dbReference;
    FirebaseRecyclerAdapter<PlacementModel, PlacementViewHolder> firebaseRecyclerAdapter2;
    RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placements);

        recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);
        recyclerView2.setHasFixedSize(true);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(layoutManager);
        dbReference = FirebaseDatabase.getInstance().getReference();

        firebaseRecyclerAdapter2 = new FirebaseRecyclerAdapter<PlacementModel, PlacementViewHolder>(
                PlacementModel.class,
                R.layout.actiivity_dynamic_placements,
                PlacementViewHolder.class,
                dbReference.child("placements").getRef()
        ) {
            @Override
            protected void populateViewHolder(PlacementViewHolder viewHolder, final PlacementModel model, int position) {

                viewHolder.title.setText(model.getPlace_title());
                progressBar.setVisibility(View.GONE);

                if (model.getPlace_img().equals(""))
                    viewHolder.img.setVisibility(View.GONE);
                else {
                    Picasso.with(getApplicationContext()).load(model.getPlace_img()).into(viewHolder.img);
                    viewHolder.img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(model.getPlace_img()));
                            startActivity(intent);
                        }
                    });
                }
                if (model.getPlace_file().equals("")) {
                    viewHolder.place_link.setVisibility(View.GONE);
                } else {
                    viewHolder.place_link.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(model.getPlace_file()));
                            startActivity(intent);
                        }
                    });
                }
            }
        };

        recyclerView2.setAdapter(firebaseRecyclerAdapter2);

        firebaseRecyclerAdapter2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int friendlyMessageCount = firebaseRecyclerAdapter2.getItemCount();
                int lastVisiblePosition =
                        layoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == -1 || (positionStart >= (friendlyMessageCount - 1) && lastVisiblePosition == (positionStart - 1))) {
                    recyclerView2.scrollToPosition(positionStart);
                }

            }
        });

        detail = (ImageButton) findViewById(R.id.detail);
        recru = (ImageButton) findViewById(R.id.recru);
        facilities = (ImageButton) findViewById(R.id.facilities);

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Placements.this, Placement_detail.class);
                startActivity(intent);
            }
        });
        recru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Placements.this, Placements_recruiters.class);
                startActivity(intent);
            }
        });
        facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Placements.this, Placement_campus_facilities.class);
                startActivity(intent);
            }
        });
    }
}
