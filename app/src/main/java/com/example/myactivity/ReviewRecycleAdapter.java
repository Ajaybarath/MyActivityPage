package com.example.myactivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class ReviewRecycleAdapter extends RecyclerView.Adapter<ReviewRecycleAdapter.MyViewHolder> {

    List<RatingReview> list;
    InputMethodManager imm;
    Context context;

    ReviewRecycleAdapter(List<RatingReview> list, Context context){

        this.list = list;
        this.context = context;
        imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView;

        if (i == 1) {
            itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.review_row_top, viewGroup, false);

        } else {

            itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.review_row, viewGroup, false);
        }

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        if (i > 0){
            RatingReview ratingReview = list.get(i-1);
            myViewHolder.review.setText(ratingReview.getReview());
            myViewHolder.name.setText(ratingReview.getName());
        }
       // new DownloadImageTask(myViewHolder.imageView).execute(ratingReview.getImage());

    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    class MyViewFetcher{
        EditText editText;
        MyViewFetcher(EditText view){
            editText = view;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 1;
        else return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, review;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.rname);
            review = (TextView) view.findViewById(R.id.rreview);
            imageView = view.findViewById(R.id.rimage);

            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return false;
                }
            });

        }

    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }





}
