package com.example.teamenvironmentkenya.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.teamenvironmentkenya.R;
import com.example.teamenvironmentkenya.databinding.FragmentTreeBinding;
import com.example.teamenvironmentkenya.models.Tree;

public class TreeFragment extends Fragment implements View.OnClickListener{
    private Tree tree;
    private FragmentTreeBinding bind;

    public TreeFragment() {
        // Required empty public constructor
    }

    public static TreeFragment newInstance(Tree tree) {
        TreeFragment fragment = new TreeFragment();
        Bundle args = new Bundle();
        args.putSerializable("tree", tree);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tree = (Tree) getArguments().getSerializable("tree");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bind = FragmentTreeBinding.inflate(getLayoutInflater());
        bind.treeName.setText(tree.getName());
        bind.addToCart.setOnClickListener(this::onClick);
        bind.buy.setOnClickListener(this::onClick);
        bind.shipping.setOnClickListener(this::onClick);
        bind.submit.setOnClickListener(this::onClick);
        return bind.getRoot();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "Coming soon, wait and relax", Toast.LENGTH_SHORT).show();
    }
}