package com.example.projectundangan.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectundangan.fragment.DataTamuFragment;
import com.example.projectundangan.fragment.ScanFragment;


public class FragmentTabAdapter extends FragmentPagerAdapter {

    public FragmentTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new ScanFragment();
        }
        return new DataTamuFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Film";
        }
        return "Tv";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
