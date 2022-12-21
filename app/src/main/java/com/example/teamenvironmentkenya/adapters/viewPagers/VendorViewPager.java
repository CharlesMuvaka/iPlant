package com.example.teamenvironmentkenya.adapters.viewPagers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.teamenvironmentkenya.fragments.VendorFragment;
import com.example.teamenvironmentkenya.models.Vendor;

import java.util.List;

public class VendorViewPager extends FragmentPagerAdapter {
    private final List<Vendor> allVendors;
    public VendorViewPager(@NonNull FragmentManager fm, int behavior, List<Vendor> allVendors) {
        super(fm, behavior);
        this.allVendors = allVendors;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return VendorFragment.newInstance(allVendors.get(position));
    }

    @Override
    public int getCount() {
        return allVendors.size();
    }
}
