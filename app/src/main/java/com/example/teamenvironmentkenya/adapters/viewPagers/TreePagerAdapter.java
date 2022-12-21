package com.example.teamenvironmentkenya.adapters.viewPagers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.teamenvironmentkenya.fragments.TreeFragment;
import com.example.teamenvironmentkenya.models.Tree;

import java.util.List;

public class TreePagerAdapter extends FragmentPagerAdapter {
    private final List<Tree> allTrees;

    public TreePagerAdapter(@NonNull FragmentManager fm, int behavior, List<Tree> allTrees) {
        super(fm, behavior);
        this.allTrees = allTrees;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return TreeFragment.newInstance(allTrees.get(position));
    }

    @Override
    public int getCount() {
        return allTrees.size();
    }
}
