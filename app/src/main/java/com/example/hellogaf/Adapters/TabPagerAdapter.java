package com.example.hellogaf.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hellogaf.Fragments.CityBreak;
import com.example.hellogaf.Fragments.Mountains;
import com.example.hellogaf.Fragments.SeaSide;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_ELEMENTS = 3;


    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new CityBreak();

            case 1:
                return new SeaSide();

            case 2:
                return new Mountains();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ELEMENTS;
    }
}
