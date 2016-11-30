package com.lansha.lanshalive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lansha.lanshalive.Model.Lives;
import com.lansha.lanshalive.R;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class LiveChildAdapter extends BaseAdapter {

    private List<Lives> data;
    private LayoutInflater inflater;

    public LiveChildAdapter(Context context, List<Lives> data) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void updataRes(List<Lives> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Lives getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.live_child_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


//        ImageOptions imageOptions = new ImageOptions.Builder()
////                .setSize(DensityUtil.dip2px(40), DensityUtil.dip2px(40))//图片大小
////                .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
////                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)//缩放
//                .setRadius(DensityUtil.dip2px(4))//ImageView圆角半径
//                .setLoadingDrawableId(R.mipmap.ic_launcher)//加载中默认显示图片
////                .setUseMemCache(true)//设置使用缓存
////                .setFailureDrawableId(R.mipmap.ic_launcher)//加载失败后默认显示图片
//                .build();
//
        x.image().bind(holder.img, getItem(position).getImg());
        x.image().bind(holder.headImg, getItem(position).getHeadImg());
        holder.name.setText(getItem(position).getName());
        holder.nickName.setText(getItem(position).getNickName());
        holder.number.setText(getItem(position).getNumber());

        return convertView;
    }

    public static class ViewHolder {
        private ImageView img;
        private ImageView headImg;
        private TextView name;
        private TextView nickName;
        private TextView number;

        public ViewHolder(View itemView) {
            img = (ImageView) itemView.findViewById(R.id.live_item_img);
            headImg = (ImageView) itemView.findViewById(R.id.live_item_headImg);
            name = (TextView) itemView.findViewById(R.id.live_item_name);
            nickName = (TextView) itemView.findViewById(R.id.live_item_nickName);
            number = (TextView) itemView.findViewById(R.id.live_item_number);
        }
    }
}
