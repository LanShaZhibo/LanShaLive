package com.lansha.lanshalive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lansha.lanshalive.Model.RecommendModel;
import com.lansha.lanshalive.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/11/28.
 */
public class RecommendGridViewAdapter extends BaseAdapter {

    private static final String TAG = RecommendGridViewAdapter.class.getSimpleName();

    private List<RecommendModel> data = new ArrayList<>();
    private LayoutInflater inflater;

    public RecommendGridViewAdapter(Context context, List<RecommendModel> rooms) {
        inflater = LayoutInflater.from(context);
        this.data = rooms;
    }


//    public void updateRes(List<RecommendModel>data){
//        if (data!=null) {
//            this.data.clear();
//            this.data.addAll(data);
//            notifyDataSetChanged();
//        }
//    }
    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public RecommendModel getItem(int position) {
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
            convertView = inflater.inflate(R.layout.recommend_lv_item,parent,false);
            holder =new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv1.setText(data.get(position).getName());
        holder.tv2.setText(data.get(position).getNumber());
        holder.tv3.setText(data.get(position).getNickName());
        x.image().bind(holder.image1,data.get(position).getImg());
        ImageOptions options = new ImageOptions.Builder()
                .setCircular(true)
                .build();
        x.image().bind(holder.image2,data.get(position).getHeadImg(),options);

        return convertView;
    }
    public static class ViewHolder{
        TextView tv1,tv2,tv3;
        ImageView image1,image2;
        public ViewHolder(View itemView) {
            tv1 = (TextView) itemView.findViewById(R.id.recommend_gv_item_name);
            tv3 = (TextView) itemView.findViewById(R.id.recommend_gv_item_nickName);
            tv2 = (TextView) itemView.findViewById(R.id.recommend_gv_item_number);
            image1 = (ImageView) itemView.findViewById(R.id.recommend_gv_item_img);

            image2 = (ImageView) itemView.findViewById(R.id.recommend_gv_item_headImg);

        }
    }
}

