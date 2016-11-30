package com.lansha.lanshalive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lansha.lanshalive.Game.GameChildFragment;
import com.lansha.lanshalive.MyUrl.GameUrl;
import com.lansha.lanshalive.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class GameFragment extends BaseFragment{
    public static final String TAG = GameFragment.class.getSimpleName();
    private ViewPagerAdapter adpter;
    private TabLayout mTabLayout;
    private ViewPager mViewPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.game_fragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mViewPage = (ViewPager) layout.findViewById(R.id.game_viewpager);

        adpter = new ViewPagerAdapter(getChildFragmentManager(),getData(),getTitles());
        mViewPage.setAdapter(adpter);

        mTabLayout = (TabLayout) layout.findViewById(R.id.game_tablayout);
        mTabLayout.setupWithViewPager(mViewPage);
    }

    public List<Fragment> getData() {
        List<Fragment> data = new ArrayList<>();
        // 填充数据
        data.add(new GameChildFragment(GameUrl.HOT));
        data.add(new GameChildFragment(GameUrl.MOBA));
        data.add(new GameChildFragment(GameUrl.MONI));
        data.add(new GameChildFragment(GameUrl.YIZHI));
        data.add(new GameChildFragment(GameUrl.OTHER));
        return data;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("最火");
        titles.add("MOBA类");
        titles.add("模拟类");
        titles.add("益智类");
        titles.add("其他分类");
        return titles;
    }
}
