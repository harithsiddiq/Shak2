package com.example.harith.shak.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentTow tow = new FragmentTow();
                return tow;
            case 1:
                FragmentOne one = new FragmentOne();
                return one;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
