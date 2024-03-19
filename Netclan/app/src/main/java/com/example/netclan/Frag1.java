package com.example.netclan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class Frag1 extends Fragment {

    private TabLayout tabLay2;
    private ViewPager viewPag2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_frag1, container, false);

        // Initialize views after inflating the layout
        tabLay2 = view.findViewById(R.id.TabLay2);
        viewPag2 = view.findViewById(R.id.ViewPager2);

        // Set up TabLayout with ViewPager
        tabLay2.setupWithViewPager(viewPag2);

        // Create and set up the ViewPager adapter
        VPadapter vpAdapter = new VPadapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new personalFrag(), "Personal");
        vpAdapter.addFragment(new BusnsFrag(), "Business");
        vpAdapter.addFragment(new merchFrag(), "Merchant");

        viewPag2.setAdapter(vpAdapter);


       return view;
        //return inflater.inflate(R.layout.fragment_frag1, container, false);
    }




}