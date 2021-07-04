package com.example.responsi;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.responsi.R;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private AdapterHome covidAdapter;
    private RecyclerView recyclerView;
    private ModelHome covidViewModel;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        covidAdapter = new AdapterHome(getContext());
        covidAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.rc_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        covidViewModel = new ViewModelProvider(this).get(ModelHome.class);
        covidViewModel.setListMutableLiveData();
        covidViewModel.getListMutableLiveData().observe(this, getContentItem);

        recyclerView.setAdapter(covidAdapter);
    }

    private Observer<ArrayList<ContentItem>> getContentItem = new Observer<ArrayList<ContentItem>>() {
        @Override
        public void onChanged(ArrayList<ContentItem> contentItems) {
            if (contentItems != null){
                covidAdapter.setData(contentItems);
            }
        }
    };
}