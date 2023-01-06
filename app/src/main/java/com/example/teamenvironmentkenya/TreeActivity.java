package com.example.teamenvironmentkenya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;

import com.example.teamenvironmentkenya.adapters.viewPagers.TreePagerAdapter;
import com.example.teamenvironmentkenya.databinding.ActivityTreeBinding;
import com.example.teamenvironmentkenya.models.Tree;

import java.util.List;

public class TreeActivity extends AppCompatActivity {
    private ActivityTreeBinding bind;
    private List<Tree> allTrees;
    private TreePagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityTreeBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        allTrees = (List<Tree>) getIntent().getSerializableExtra("allTrees");
        int position = getIntent().getIntExtra("position", 0);
        adapter = new TreePagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, allTrees);

        bind.viewPager.setAdapter(adapter);
        bind.viewPager.setCurrentItem(position);
    }
}