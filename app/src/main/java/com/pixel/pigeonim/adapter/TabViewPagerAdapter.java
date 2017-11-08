package com.pixel.pigeonim.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wongchen on 2017/11/8.
 */

public class TabViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> views;
    private List<String> titles;

    public TabViewPagerAdapter(FragmentManager fm, List<String> titles, List<Fragment> views) {
        super(fm);
        this.views = views;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
