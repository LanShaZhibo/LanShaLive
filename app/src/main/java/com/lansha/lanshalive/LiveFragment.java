package com.lansha.lanshalive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lansha.lanshalive.Live.LiveChildFragment;
import com.lansha.lanshalive.MyUrl.LiveUrl;
import com.lansha.lanshalive.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class LiveFragment  extends BaseFragment {

    public static final String TAG = LiveFragment.class.getSimpleName();
    private ViewPagerAdapter adpter;
    private TabLayout mTabLayout;
    private ViewPager mViewPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.live_fragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mViewPage = (ViewPager) layout.findViewById(R.id.live_viewpager);

        adpter = new ViewPagerAdapter(getChildFragmentManager(),getData(),getTitles());
        mViewPage.setAdapter(adpter);

        mTabLayout = (TabLayout) layout.findViewById(R.id.live_tablayout);
        mTabLayout.setupWithViewPager(mViewPage);
    }

    public List<Fragment> getData() {
        List<Fragment> data = new ArrayList<>();
        // 填充数据
        data.add(new LiveChildFragment(LiveUrl.TUIJIAN));
        data.add(new LiveChildFragment(LiveUrl.ZUIRE));
        data.add(new LiveChildFragment(LiveUrl.ZUIXIN));
        return data;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("最热");
        titles.add("最新");
        return titles;
    }
}
