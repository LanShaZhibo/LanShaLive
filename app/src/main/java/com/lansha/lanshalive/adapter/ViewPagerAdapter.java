package com.lansha.lanshalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    private List<String> titles;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> data, List<String> titles) {
        super(fm);
        this.data = data;
        this.titles = titles;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
