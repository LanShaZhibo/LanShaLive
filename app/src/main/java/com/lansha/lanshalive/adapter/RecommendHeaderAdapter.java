package com.lansha.lanshalive.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/11/29.
 */
public class RecommendHeaderAdapter extends PagerAdapter {
    private List<ImageView> imgList;

    public RecommendHeaderAdapter(List<ImageView> imgList) {
        if (imgList != null) {
            this.imgList = imgList;
        } else {
            this.imgList = new ArrayList<>();
        }
    }

    @Override
    public ImageView instantiateItem(ViewGroup container, int position) {
        if (imgList != null && imgList.size() > position) {
            container.addView(imgList.get(position));
            return imgList.get(position);
        }
        return null;
    }

    public void updateRes(List<ImageView> data) {
        if (data != null) {
            imgList.clear();
            imgList.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (imgList != null && imgList.size() > position) {
            container.removeView(imgList.get(position));
        }
    }

    @Override
    public int getCount() {
        return imgList != null ? imgList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}