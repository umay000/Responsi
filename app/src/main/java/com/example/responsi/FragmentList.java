package com.example.responsi;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi.R;

import java.util.ArrayList;

public class FragmentList extends Fragment {

    private AdapterList hospitalAdapter;
    private RecyclerView recyclerView;
    private ModelList hospitalViewModel;

    public FragmentList() {
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
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hospitalAdapter = new AdapterList(getActivity(), new ArrayList<>());
        hospitalAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.rc_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        hospitalViewModel = new ViewModelProvider(this).get(ModelList.class);
        hospitalViewModel.setListMutableLiveData();
        hospitalViewModel.getListMutableLiveData().observe(this, getDataItem);

        recyclerView.setAdapter(hospitalAdapter);
    }

    private Observer<ArrayList<DataRS>> getDataItem = new Observer<ArrayList<DataRS>>() {
        @Override
        public void onChanged(ArrayList<DataRS> contentItems) {
            if (contentItems != null){
                hospitalAdapter.setData(contentItems);
            }
        }
    };
}