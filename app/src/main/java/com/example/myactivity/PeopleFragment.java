package com.example.myactivity;

import android.app.SearchManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabWidget;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.getSystemService;


public class PeopleFragment extends Fragment implements PeopleRecycelAdapter.SearchListener, PeopleRecycelAdapter.FollowListener {

    List<People> list;

    SearchView searchView ;

    PeopleRecycelAdapter adapter;
    RecyclerView recyclerView;

    private SearchView.OnQueryTextListener queryTextListener;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        list = new ArrayList<>();


        list.add(new People("ajay", "s"));
        list.add(new People("ajkjsdfngjay", "s"));
        list.add(new People("ajsjkay", "s"));
        list.add(new People("iuhiu", "s"));
        list.add(new People("ajsjkay", "s"));
        list.add(new People("88uioj", "s"));
        list.add(new People("nbvjvi", "s"));
        list.add(new People("iuyiu", "s"));
        list.add(new People("hvbnnjk", "s"));
        list.add(new People("mjhl", "s"));
        list.add(new People("yyugjk", "s"));
        list.add(new People("nbvjhgiy", "s"));
        list.add(new People("rewrv", "s"));

        final View view = inflater.inflate(R.layout.fragment_people, container, false);
        final View view1 = inflater.inflate(R.layout.people_row_top, container, false);

        final FragmentActivity c = getActivity();
        recyclerView = (RecyclerView) view.findViewById(R.id.peopleRecycleView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new PeopleRecycelAdapter(list,this,this);
        recyclerView.setAdapter(adapter);

        return view;

    }

    @Override
    public void onSearchSelected(View view) {
        System.out.println("Search selected");

        searchView = view.findViewById(R.id.search_people);

    }

    @Override
    public void onSearchQueried(String s) {
        System.out.println("Search queried ");
        adapter.getFilter().filter(s);
    }

    @Override
    public void onClickedFollow(People people) {
        Toast.makeText(getContext(), "You are following " + people.getName(), Toast.LENGTH_SHORT).show();
    }
}
