package com.example.teamenvironmentkenya.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamenvironmentkenya.R;
import com.example.teamenvironmentkenya.adapters.recyclerViews.TreeRecAdapter;
import com.example.teamenvironmentkenya.database.DatabaseClient;
import com.example.teamenvironmentkenya.databinding.FragmentShopBinding;
import com.example.teamenvironmentkenya.models.Tree;

import java.util.ArrayList;
import java.util.List;


public class ShopFragment extends Fragment {
    private FragmentShopBinding bind;
    private List<Tree> allTrees;
    private TreeRecAdapter adapter;
    private DatabaseClient client;

    public ShopFragment() {
        // Required empty public constructor
    }

    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
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
        bind = FragmentShopBinding.inflate(getLayoutInflater());

        allTrees = new ArrayList<>();
        client = DatabaseClient.getInstance(getContext());

        allTrees = client.TreeDao().getAllTrees();
        adapter = new TreeRecAdapter(allTrees, getContext());

        bind.recView.setAdapter(adapter);
        bind.recView.setLayoutManager(new LinearLayoutManager(getContext()));
        bind.recView.setHasFixedSize(true);

        return bind.getRoot();
    }
}