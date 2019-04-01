package com.example.myactivity;

import android.app.SearchManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import java.io.SyncFailedException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.getSystemService;

public class PeopleRecycelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    List<People> list;
    List<People> listFiltered;


    SearchListener listener;
    FollowListener followListener;

    PeopleRecycelAdapter(List<People> list, SearchListener listener, FollowListener followListener){
        this.list = list;
        this.listFiltered = list;
        this.listener = listener;
        this.followListener = followListener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                System.out.println(constraint.toString());
                String name = constraint.toString();

                if (name.isEmpty()){
                    listFiltered = list;
                }
                else {
                    List<People> filteringList = new ArrayList<>();
                    for (People row: list){
                        if (row.getName().toLowerCase().contains(name.toLowerCase())){
                            filteringList.add(row);
                        }
                    }
                    listFiltered = filteringList;
                    notifyDataSetChanged();

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listFiltered;

                return filterResults;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }

        };
    }

    class MySearchHolder extends RecyclerView.ViewHolder{

        SearchView searchView;

        MySearchHolder(View itemView) {
            super(itemView);
            searchView = (SearchView) itemView.findViewById(R.id.search_people);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    System.out.println(2 + "***********************************...");
                    listener.onSearchQueried(s);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    System.out.println(s + "***********************************111");
                    listener.onSearchQueried(s);
                    return false;
                }
            });

        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView imageView;
        public Button follow;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.mname);
            imageView = view.findViewById(R.id.mprofile_image);
            follow = view.findViewById(R.id.mfollow);

            follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    followListener.onClickedFollow(listFiltered.get(getAdapterPosition()));
                }
            });

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 1;
        else return 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView;

        if (i == 1) {
            itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.people_row_top, viewGroup, false);
            return new MySearchHolder(itemView);

        } else {

            itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.people_row, viewGroup, false);
            return new MyViewHolder(itemView);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (i > 0) {
            final People people = listFiltered.get(i);
            ((MyViewHolder)viewHolder).name.setText(people.getName());
        }
    }


    @Override
    public int getItemCount() {
        return listFiltered.size();
    }

    public interface SearchListener{
        void onSearchSelected(View view);
        void onSearchQueried(String s);
    }

    public interface FollowListener{
        void onClickedFollow(People people);
    }

}
