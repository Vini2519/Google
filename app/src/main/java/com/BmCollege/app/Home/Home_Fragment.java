package com.BmCollege.app.Home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.BmCollege.app.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;
import com.squareup.picasso.Picasso;


public class Home_Fragment extends Fragment {
    private LoopViewPager viewPager;
    private CircleIndicator indicator;
    private ProgressBar progressBar;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<FirebaseModel, FirebaseViewHolder> firebaseRecyclerAdapter;
    RecyclerView recyclerView;

    public Home_Fragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home_, container, false);
        viewPager = (LoopViewPager) view.findViewById(R.id.viewpager);
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        progressBar=(ProgressBar)view.findViewById(R.id.progress_bar2);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<FirebaseModel, FirebaseViewHolder>(
                FirebaseModel.class,
                R.layout.notice_item_view,
                FirebaseViewHolder.class,
                databaseReference.child("notices").getRef()
        ) {
            @Override
            protected void populateViewHolder(FirebaseViewHolder viewHolder, final FirebaseModel model,int position) {
                viewHolder.title.setText(model.getTitle());
                progressBar.setVisibility(View.GONE);

                if (model.getImage_url().equals(""))
                    viewHolder.image.setVisibility(View.GONE);
                else {
                    Picasso.with(getContext()).load(model.getImage_url()).into(viewHolder.image);
                    viewHolder.image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(model.getImage_url()));
                            startActivity(intent);
                        }
                    });
                }
                if (model.getFile().equals(""))
                    viewHolder.file_url.setVisibility(View.GONE);
                else {
                    viewHolder.file_url.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(model.getFile()));
                            getContext().startActivity(intent);

                        }
                    });
                }
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

        firebaseRecyclerAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int friendlyMessageCount = firebaseRecyclerAdapter.getItemCount();
                int lastVisiblePosition =
                        linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == -1 ||
                        (positionStart >= (friendlyMessageCount - 1) &&
                                lastVisiblePosition == (positionStart - 1))) {
                    recyclerView.scrollToPosition(positionStart);
                }
            }
        });
        viewPager.setAdapter(new PicAdapter(Home_Fragment.this));
        viewPager.setLooperPic(true);
        indicator.setViewPager(viewPager);
        return view;
    }
}
