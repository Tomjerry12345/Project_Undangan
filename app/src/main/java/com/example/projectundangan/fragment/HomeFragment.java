package com.example.projectundangan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.projectundangan.R;
import com.example.projectundangan.adapter.FragmentTabAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {


    public HomeFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.home_tablayout);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.home_viewpager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new FragmentTabAdapter(getChildFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);
    }
}
