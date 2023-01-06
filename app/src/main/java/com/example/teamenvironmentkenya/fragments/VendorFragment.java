package com.example.teamenvironmentkenya.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamenvironmentkenya.R;
import com.example.teamenvironmentkenya.databinding.FragmentVendorBinding;
import com.example.teamenvironmentkenya.models.Vendor;

public class VendorFragment extends Fragment {
    private Vendor vendor;
    private FragmentVendorBinding bind;

    public VendorFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static VendorFragment newInstance(Vendor vendor) {
        VendorFragment fragment = new VendorFragment();
        Bundle args = new Bundle();
        args.putSerializable("vendor", vendor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            vendor = (Vendor) getArguments().getSerializable("vendor");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bind = FragmentVendorBinding.inflate(getLayoutInflater());
        bind.vendorName.setText(vendor.getName());
        bind.vendorEmail.setText(vendor.getUserEmail());
        bind.vendorLocation.setText(vendor.getLocation());
        bind.vendorPhone.setText(vendor.getPhoneNumber());
        return bind.getRoot();
    }
}