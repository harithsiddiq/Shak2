package com.example.harith.shak.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;

import com.example.harith.shak.R;
import com.example.harith.shak.db.DataBaseHelper;
import com.example.harith.shak.db.LecAdapter;
import com.example.harith.shak.db.Users;

import java.util.ArrayList;


public class FragmentOne extends Fragment {
    SwipeRefreshLayout mSwipeRefreshLayout;
    DataBaseHelper helper;
    View view;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        helper = new DataBaseHelper(getContext());

        mSwipeRefreshLayout = view.findViewById(R.id.refresh);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<Users> num = helper.getAllUser();

                        LecAdapter adapter = new LecAdapter(getContext(),num);

                        ListView listView = view.findViewById(R.id.list);

                        listView.setAdapter(adapter);

                        adapter.notifyDataSetChanged();

                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });

        return view;
    }




}
