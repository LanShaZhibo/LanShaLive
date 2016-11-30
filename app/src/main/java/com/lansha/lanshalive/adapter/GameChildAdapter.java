package com.lansha.lanshalive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lansha.lanshalive.Model.Games;
import com.lansha.lanshalive.R;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class GameChildAdapter extends BaseAdapter {

    private List<Games> data;
    private LayoutInflater inflater;

    public GameChildAdapter(Context context, List<Games> data) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void updataRes(List<Games> data) {
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
    public Games getItem(int position) {
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
            convertView = inflater.inflate(R.layout.game_child_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.gameName.setText(getItem(position).getName());
        x.image().bind(holder.gameIcon,getItem(position).getImg());

        return convertView;
    }

    public static class ViewHolder {
        private ImageView gameIcon;
        private TextView gameName;

        public ViewHolder(View itemView) {
            gameIcon = (ImageView) itemView.findViewById(R.id.game_child_item_icon);
            gameName = (TextView) itemView.findViewById(R.id.game_child_item_name);
        }
    }
}
