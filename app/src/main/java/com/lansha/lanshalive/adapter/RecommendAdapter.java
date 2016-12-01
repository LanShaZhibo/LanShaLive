package com.lansha.lanshalive.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.lansha.lanshalive.HomePage.InitGridView;
import com.lansha.lanshalive.LiveActivity;
import com.lansha.lanshalive.Model.ListViewModel;
import com.lansha.lanshalive.Model.RecommendModel;
import com.lansha.lanshalive.R;

import java.util.List;

/**
 * Created by my on 2016/11/28.
 */
public class RecommendAdapter extends TeachBaseAdapter<ListViewModel> implements AdapterView.OnItemClickListener {
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
        adapter = new RecommendGridViewAdapter(holder.itemView.getContext(),item.getRooms());
        mGridView.setOnItemClickListener(this);
        mGridView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RecommendModel item = adapter.getItem(position);
        Intent intent = new Intent(parent.getContext(), LiveActivity.class);
        intent.putExtra("liveUrl",item.getRtmp());
        view.getContext().startActivity(intent);
    }
}
