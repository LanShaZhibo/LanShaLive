package com.lansha.lanshalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by my on 2016/11/28.
 */
public class HomePagerViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private List<String> title;

    public HomePagerViewPagerAdapter(FragmentManager fm, List<Fragment>data, List<String >title) {

        super(fm);
        this.data = data;
        this.title = title;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }
}
