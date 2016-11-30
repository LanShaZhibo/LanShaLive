package com.lansha.lanshalive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lansha.lanshalive.Model.GameSeconVideo.VideoList;
import com.lansha.lanshalive.R;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wind on 2016/11/30 0030.
 */
public class GameSecondVideoAdapter extends BaseAdapter {

    private List<VideoList> data;
    private LayoutInflater inflater;

    public GameSecondVideoAdapter(Context context, List<VideoList> data) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void updataRes(List<VideoList> data) {
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
    public VideoList getItem(int position) {
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
            convertView = inflater.inflate(R.layout.game_second_video_lv_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        x.image().bind(holder.coverAddress,getItem(position).getCoverAddress());
        holder.videoName.setText(getItem(position).getVideoName());
        holder.nickname.setText(getItem(position).getNickname());
        holder.clickNumber.setText(getItem(position).getClickNumber()+"次");
        holder.videoTimeStr.setText(getItem(position).getVideoTimeStr());
        return convertView;
    }


    public class ViewHolder{
        ImageView coverAddress;
        TextView nickname;
        TextView videoName;
        TextView clickNumber;
        TextView videoTimeStr;

        public ViewHolder(View itemView) {
            coverAddress = (ImageView) itemView.findViewById(R.id.video_item_coverAddress);
            nickname = (TextView) itemView.findViewById(R.id.video_item_nickname);
            videoName = (TextView) itemView.findViewById(R.id.video_item_videoName);
            clickNumber = (TextView) itemView.findViewById(R.id.video_item_clickNumber);
            videoTimeStr = (TextView) itemView.findViewById(R.id.video_item_videoTimeStr);
        }
    }

}
