package com.lansha.lanshalive.Game;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lansha.lanshalive.BaseFragment;
import com.lansha.lanshalive.MyUrl.GameUrl;
import com.lansha.lanshalive.R;
import com.lansha.lanshalive.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wind on 2016/11/30 0030.
 */
public class GameSecondVideo extends BaseFragment {
    public static final String TAG = GameSecondVideo.class.getSimpleName();
    private ViewPagerAdapter adpter;
    private TabLayout mTabLayout;
    private ViewPager mViewPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.game_second_video,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mViewPage = (ViewPager) layout.findViewById(R.id.game_second_video_vp);

        adpter = new ViewPagerAdapter(getChildFragmentManager(),getData(),getTitles());
        mViewPage.setAdapter(adpter);

        mTabLayout = (TabLayout) layout.findViewById(R.id.game_second_video_tab);
        mTabLayout.setupWithViewPager(mViewPage);
    }

    public List<Fragment> getData() {
        List<Fragment> data = new ArrayList<>();
        // 填充数据
        data.add(new GameSecondVideoFragment(GameUrl.SecondVideoZuiXin));
        data.add(new GameSecondVideoFragment(GameUrl.SecondVideoZuiRe));
        data.add(new GameSecondVideoFragment(GameUrl.SecondVideoRenQi));
        return data;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("最新");
        titles.add("最热");
        titles.add("人气");
        return titles;
    }

}
