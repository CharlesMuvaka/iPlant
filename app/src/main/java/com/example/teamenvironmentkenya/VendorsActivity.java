package com.example.teamenvironmentkenya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;

import com.example.teamenvironmentkenya.adapters.viewPagers.VendorViewPager;
import com.example.teamenvironmentkenya.databinding.ActivityVendorsBinding;
import com.example.teamenvironmentkenya.models.Vendor;

import java.util.List;

public class VendorsActivity extends AppCompatActivity {
    private ActivityVendorsBinding bind;
    private VendorViewPager pager;
    private List<Vendor> allVendors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityVendorsBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        allVendors = (List<Vendor>) getIntent().getSerializableExtra("allVendors");
        int position = getIntent().getIntExtra("position", 0);

        pager = new VendorViewPager(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, allVendors);
        bind.viewPager.setAdapter(pager);
        bind.viewPager.setCurrentItem(position);
    }
}