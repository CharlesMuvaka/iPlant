package com.example.teamenvironmentkenya.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamenvironmentkenya.adapters.recyclerViews.VendorRecAdapter;
import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.FragmentVendorsBinding;
import com.example.teamenvironmentkenya.models.Vendor;

import java.util.ArrayList;
import java.util.List;


public class VendorsFragment extends Fragment {
    private FragmentVendorsBinding bind;
    private VendorRecAdapter adapter;
    private List<Vendor> allVendors;
    private DatabaseClient client;

    public VendorsFragment() {
        // Required empty public constructor
    }


    public static VendorsFragment newInstance(String param1, String param2) {
        VendorsFragment fragment = new VendorsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bind = FragmentVendorsBinding.inflate(getLayoutInflater());

        client = DatabaseClient.getInstance(getContext());
        allVendors = new ArrayList<>();
        allVendors = client.VendorDao().getAllVendors();
        adapter = new VendorRecAdapter( allVendors, getContext());

        bind.myRecView.setAdapter(adapter);
        bind.myRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        bind.myRecView.setHasFixedSize(true);
        return bind.getRoot();
    }
}