package com.example.myactivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.example.myactivity.R;

import java.util.ArrayList;
import java.util.List;

public class ReviewFragment extends Fragment {


    private List<RatingReview> reviewList;

    ImageView s1, s2, s3, s4, s5;

    int rating = 1;
    ReviewRecycleAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        reviewList = new ArrayList<>();


        final View view = inflater.inflate(R.layout.fragment_review, container, false);
        final FragmentActivity c = getActivity();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.reviewRecycler);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new ReviewRecycleAdapter(reviewList, getContext());
        recyclerView.setAdapter(adapter);


        reviewList.add(new RatingReview(5, "Ajay", "It was a very good experience.", "ajkd"));
        reviewList.add(new RatingReview(5, "Barath", "Lorem ipsum dolor sit amet,ut aliquip ex ea commodo consequat.\"", "ajkd"));
        reviewList.add(new RatingReview(5, "Vijay", "I has made me learn a lot.", "ajkd"));
        reviewList.add(new RatingReview(5, "Vishal", "Learnt to rectify errors and debug.", "ajkd"));
        reviewList.add(new RatingReview(5, "Aswath", "Implementing Search Bar was not a easy task.", "ajkd"));
        reviewList.add(new RatingReview(5, "Sharan", "First time working with fragments", "ajkd"));
        reviewList.add(new RatingReview(5, "Deepak", "Love to do a lot more like this", "ajkd"));


        return view;

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void getRating() {

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2.setImageResource(R.drawable.ic_heart);
                s3.setImageResource(R.drawable.ic_heart);
                s4.setImageResource(R.drawable.ic_heart);
                s5.setImageResource(R.drawable.ic_heart);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2.setImageResource(R.drawable.ic_heart_active);
                s3.setImageResource(R.drawable.ic_heart);
                s4.setImageResource(R.drawable.ic_heart);
                s5.setImageResource(R.drawable.ic_heart);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2.setImageResource(R.drawable.ic_heart_active);
                s3.setImageResource(R.drawable.ic_heart_active);
                s4.setImageResource(R.drawable.ic_heart);
                s5.setImageResource(R.drawable.ic_heart);
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2.setImageResource(R.drawable.ic_heart_active);
                s3.setImageResource(R.drawable.ic_heart_active);
                s4.setImageResource(R.drawable.ic_heart_active);
                s5.setImageResource(R.drawable.ic_heart);
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2.setImageResource(R.drawable.ic_heart_active);
                s3.setImageResource(R.drawable.ic_heart_active);
                s4.setImageResource(R.drawable.ic_heart_active);
                s5.setImageResource(R.drawable.ic_heart_active);
            }
        });


    }


}