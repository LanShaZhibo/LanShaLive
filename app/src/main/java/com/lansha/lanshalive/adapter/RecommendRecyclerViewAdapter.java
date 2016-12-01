package com.lansha.lanshalive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lansha.lanshalive.Model.RecyclerModel;
import com.lansha.lanshalive.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/11/29.
 */
public class RecommendRecyclerViewAdapter extends RecyclerView.Adapter<RecommendRecyclerViewAdapter.ViewHolder>  {
    private List<RecyclerModel> data;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;
    private onRecyclerItemClickListener mRecyclerListener;

    public void setOnRecyclerListener(onRecyclerItemClickListener mRecyclerListener) {
        this.mRecyclerListener = mRecyclerListener;
    }

    public RecommendRecyclerViewAdapter(Context context, List<RecyclerModel>data){
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>();
    }
    public void updateRes(List<RecyclerModel> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView =recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView=null;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = inflater.inflate(R.layout.recommend_recycler_item,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(data.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int layoutPosition = holder.getLayoutPosition();
               // mRecyclerListener.ItemClickListener(url,holder.itemView,layoutPosition);
                if (mRecyclerView!=null) {
                    int childAdapterPosition = mRecyclerView.getChildAdapterPosition(v);
                    if (mRecyclerListener!=null) {
                        mRecyclerListener.ItemClickListener(data.get(layoutPosition).getRtmp(),v,childAdapterPosition);
                    }
                }
            }
        });
        ImageOptions options = new ImageOptions.Builder()
                .setCircular(true)
                .build();
        x.image().bind(holder.image,data.get(position).getImg(), options);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.recycler_name);
            image = (ImageView) itemView.findViewById(R.id.recycler_iamge);
        }
    }
    public interface  onRecyclerItemClickListener{
        void ItemClickListener(String url,View view,int position);
    }
}
