package com.lansha.lanshalive.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lansha.lanshalive.LiveActivity;
import com.lansha.lanshalive.Model.RecommendModel;
import com.lansha.lanshalive.R;
import com.lansha.lanshalive.adapter.RecommendChildAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/11/28.
 */
@ContentView(R.layout.fg_hp_childfragment)
public class HomePageChildFragment extends Fragment implements AdapterView.OnItemClickListener {
    @ViewInject(R.id.recommend_child_gv)
    private GridView mGridView;
    private String URL;
    private RecommendChildAdapter adapter;
    private List<RecommendModel>data = new ArrayList<>();

    public HomePageChildFragment(String URL) {
        this.URL = URL;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView();
    }

    private void setupView() {
        RequestParams params = new RequestParams(URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject object = jsonObject.getJSONObject("data");
                    JSONArray array = object.getJSONArray("rooms");
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<RecommendModel>>() {
                    }.getType();
                    data = gson.fromJson(array.toString(),type);
                    adapter.updateRes(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initView() {
        adapter = new RecommendChildAdapter(getContext(),null, R.layout.recommend_child_item);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RecommendModel item = adapter.getItem(position);
        Intent intent = new Intent(parent.getContext(), LiveActivity.class);
        intent.putExtra("liveUrl",item.getRtmp());
        view.getContext().startActivity(intent);
    }
}
