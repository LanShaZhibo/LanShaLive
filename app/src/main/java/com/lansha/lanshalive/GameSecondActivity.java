package com.lansha.lanshalive;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lansha.lanshalive.Game.GameSecondVideo;
import com.lansha.lanshalive.Live.LiveChildFragment;
import com.lansha.lanshalive.MyUrl.GameUrl;
import com.lansha.lanshalive.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameSecondActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter adapter;
    private Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_second);
        initView();

    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.game_second_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.game_second_viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),getData(),getTitles());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public List<Fragment> getData() {
        List<Fragment> data = new ArrayList<>();
        data.add(new LiveChildFragment(GameUrl.Second));
        data.add(new GameSecondVideo());
        return data;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("直播");
        titles.add("视频");
        return titles;
    }

}
