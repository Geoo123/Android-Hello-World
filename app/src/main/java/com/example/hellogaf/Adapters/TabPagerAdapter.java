package com.example.hellogaf.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hellogaf.Fragments.hello_fragment;
import com.example.hellogaf.Fragments.hello_fragment1;
import com.example.hellogaf.Fragments.hello_fragment2;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_ELEMENTS = 3;


    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new hello_fragment();

            case 1:
                return new hello_fragment1();

            case 2:
                return new hello_fragment2();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ELEMENTS;
    }
}
