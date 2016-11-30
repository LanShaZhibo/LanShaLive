package com.lansha.lanshalive.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.lansha.lanshalive.HomePage.InitGridView;
import com.lansha.lanshalive.Model.ListViewModel;
import com.lansha.lanshalive.R;

import java.util.List;

/**
 * Created by my on 2016/11/28.
 */
public class RecommendAdapter extends TeachBaseAdapter<ListViewModel>{
    private static final String TAG = RecommendAdapter.class.getCanonicalName();
    private InitGridView mGridView;
    private RecommendGridViewAdapter adapter;

    public RecommendAdapter(Context context, List<ListViewModel> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void BindData(ViewHolder holder, ListViewModel item, int position) {
        TextView name = (TextView) holder.getView(R.id.lv_name);
        name.setText(item.getName());
        mGridView = (InitGridView) holder.itemView.findViewById(R.id.recommend_gv);
        Log.e("oooooooooooooooooo", "BindData: " );
        adapter = new RecommendGridViewAdapter(holder.itemView.getContext(),item.getRooms());

        mGridView.setAdapter(adapter);
        Log.e("mmmmmmmmmmmmmmmmm", "BindData: " );
    }

}
