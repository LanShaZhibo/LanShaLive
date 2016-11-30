package com.lansha.lanshalive.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.lansha.lanshalive.Model.RecommendModel;
import com.lansha.lanshalive.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by my on 2016/11/29.
 */
public class RecommendChildAdapter extends TeachBaseAdapter<RecommendModel> {
    public RecommendChildAdapter(Context context, List<RecommendModel> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void BindData(ViewHolder holder, RecommendModel item, int position) {
        TextView name;
        name = (TextView) holder.getView(R.id.live_item_name);
        name.setText(item.getName());
        TextView nickname;
        nickname = (TextView) holder.getView(R.id.live_item_nickName);
        nickname.setText(item.getNickName());
        TextView number;
        number = (TextView) holder.getView(R.id.live_item_number);
        number.setText(item.getNumber());

        ImageView image, touxiang;
        image = (ImageView) holder.getView(R.id.live_item_img);
        x.image().bind(image,item.getImg());
        touxiang = (ImageView) holder.getView(R.id.live_item_headImg);
        ImageOptions options = new ImageOptions.Builder()
                .setCircular(true)
                .build();
        x.image().bind(touxiang,item.getHeadImg(), options);
    }
}
