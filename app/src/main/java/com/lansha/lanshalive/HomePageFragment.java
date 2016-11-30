package com.lansha.lanshalive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lansha.lanshalive.HomePage.HomePageChildFragment;
import com.lansha.lanshalive.HomePage.Recommend;
import com.lansha.lanshalive.MyUrl.RecommendUrl;
import com.lansha.lanshalive.adapter.HomePagerViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class HomePageFragment  extends BaseFragment {
    public static final String TAG = HomePageFragment.class.getSimpleName();
    private List<String> title;
    private List<Fragment>data;
    private TabLayout mTab;
    private ViewPager mViewPager;
    private HomePagerViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.homepage_fragment,container,false);
        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mTab = ((TabLayout) layout.findViewById(R.id.homepage_tabLayout));
        mViewPager = ((ViewPager) layout.findViewById(R.id.homepage_viewPager));

        title = new ArrayList<>();
        data = new ArrayList<>();
        data = getData();
        title = getTitle();
        adapter = new HomePagerViewPagerAdapter(getChildFragmentManager(), data, title);
        mViewPager.setAdapter(adapter);
        mTab.setupWithViewPager(mViewPager);


    }

    public List<String> getTitle() {
        title.add("推荐");
        title.add("全部直播");
        title.add("王者荣耀");
        title.add("穿越火线");
        title.add("街篮");
        title.add("天天酷跑");
        title.add("球球大作战");
        title.add("其他手游");
        return title;

    }

    public List<Fragment> getData() {
        data.add(new Recommend());
        data.add(new HomePageChildFragment(RecommendUrl.RECOMMEND_QUANBU_URL));
        data.add(new HomePageChildFragment(RecommendUrl.RECOMMEND_WANGZHE_URL));
        data.add(new HomePageChildFragment(RecommendUrl.RECOMMEND_CF_URL));
        data.add(new HomePageChildFragment(RecommendUrl.RECOMMEND_JIELAN_URL));
        data.add(new HomePageChildFragment(RecommendUrl.RECOMMEND_KUPAO_URL));
        data.add(new HomePageChildFragment(RecommendUrl.RECOMMEND_QIUQIU_URL));
        data.add(new HomePageChildFragment(RecommendUrl.RECOMMEND_QITA_URL));
        return data;
    }
}
