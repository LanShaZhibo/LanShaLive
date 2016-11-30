package com.lansha.lanshalive.HomePage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lansha.lanshalive.MainActivity;
import com.lansha.lanshalive.Model.ListViewModel;
import com.lansha.lanshalive.Model.RecommendHeader;
import com.lansha.lanshalive.Model.RecyclerModel;
import com.lansha.lanshalive.MyUrl.HttpUrl;
import com.lansha.lanshalive.R;
import com.lansha.lanshalive.adapter.RecommendAdapter;
import com.lansha.lanshalive.adapter.RecommendHeaderAdapter;
import com.lansha.lanshalive.adapter.RecommendRecyclerViewAdapter;

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
@ContentView(R.layout.fg_hp_recommend)
public class Recommend extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    @ViewInject(R.id.recommend_lv)
    private ListView mListView;
    private RecommendAdapter adapter;
    private List<ListViewModel> data = new ArrayList<>();
    private View mheader;
    private RecommendHeaderAdapter vpadapter;
    private List<ImageView> list = new ArrayList<>();
    private int[] imgid = {R.mipmap.ic_launcher};
    private ViewPager mViewPager;
    private List<RecyclerModel> recydata;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x110) {
                int currentindex = mViewPager.getCurrentItem();
                currentindex++;
                if (list.size()!=0) {
                    mViewPager.setCurrentItem(currentindex%list.size());
                }

            }
        }
    };
    private RecyclerView mRecy;
    private RecommendRecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        getVpView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(5000);
                    handler.sendEmptyMessage(0x110);
                }
            }
        }).start();
        getrecyclerView();
        setupView();
    }

    private void getrecyclerView() {
        RequestParams params = new RequestParams(HttpUrl.RECOMMEND_URL);
        x.http().get(params, new Callback.CommonCallback<String >() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject object = jsonObject.getJSONObject("data");
                    JSONArray array = object.getJSONArray("rooms1");
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<RecyclerModel>>() {
                    }.getType();
                    recydata = gson.fromJson(array.toString(),type);
                    recyclerViewAdapter.updateRes(recydata);

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

    private void getVpView() {
        RequestParams params = new RequestParams(HttpUrl.RECOMMEND_URL);
        x.http().get(params, new Callback.CommonCallback<String >() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject object = jsonObject.getJSONObject("data");
                    JSONArray array = object.getJSONArray("banner");
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<RecommendHeader>>() {
                    }.getType();

                    List<RecommendHeader> data = gson.fromJson(array.toString(),type);
                    list.clear();
                    for (int i = 0; i < data.size(); i++) {
                        ImageView img = new ImageView(getContext());
                        img.setImageResource(imgid[0]);
                        x.image().bind(img,data.get(i).getImg());
                        list.add(img);
                        vpadapter.updateRes(list);
                    }

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

    private void setupView() {
        RequestParams params = new RequestParams(HttpUrl.RECOMMEND_URL);
        x.http().get(params, new Callback.CommonCallback<String >() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject object = jsonObject.getJSONObject("data");
                    JSONArray obj = object.getJSONArray("rooms2");
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ListViewModel>>() {
                    }.getType();
                    data = gson.fromJson(obj.toString(),type);
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
        mheader = LayoutInflater.from(getActivity()).inflate(R.layout.recommend_header,null);
        mViewPager = ((ViewPager) mheader.findViewById(R.id.recommend_header_vp));
        vpadapter = new RecommendHeaderAdapter(null);
        mViewPager.setAdapter(vpadapter);

        mRecy = ((RecyclerView) mheader.findViewById(R.id.recommend_header_rv));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecy.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecommendRecyclerViewAdapter(getContext(),null);
        mRecy.setAdapter(recyclerViewAdapter);

        mListView.addHeaderView(mheader);
        adapter = new RecommendAdapter(getContext(),null,R.layout.hp_recommend_item);
        mListView.setAdapter(adapter);


    }
}
