package com.lansha.lanshalive.Live;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lansha.lanshalive.BaseFragment;
import com.lansha.lanshalive.LiveActivity;
import com.lansha.lanshalive.Model.LiveData;
import com.lansha.lanshalive.R;
import com.lansha.lanshalive.adapter.LiveChildAdapter;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class LiveChildFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private static final String TAG = LiveChildFragment.class.getCanonicalName();
    private GridView mGridView;
    private LiveChildAdapter adapter;
    private String URL;
    public String GameSeconfHeaderUrl;
    private ImageView mHeader;

    public LiveChildFragment(String URL) {
        this.URL = URL;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.live_child_fragment, container, false);
        return layout;
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
                Gson gson = new Gson();

                try {
                    JSONObject JsonObject = new JSONObject(result);

                    JSONObject data = JsonObject.getJSONObject("data");

                    LiveData liveData = gson.fromJson(data.toString(), LiveData.class);

                    adapter.updataRes(liveData.getRooms());

                    if (liveData.getBanners() != null) {
                        GameSeconfHeaderUrl = liveData.getBanners().get(0).getImg();
                        x.image().bind(mHeader, GameSeconfHeaderUrl);
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

    private void initView() {
        mGridView = (GridView) layout.findViewById(R.id.game_child_gridview);
        adapter = new LiveChildAdapter(getActivity(), null);
        mGridView.setAdapter(adapter);
        mHeader = (ImageView) getActivity().findViewById(R.id.game_second_header);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String liveUrl = adapter.getItem(position).getRtmp();
        Intent intent = new Intent(getActivity().getApplicationContext(), LiveActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("liveUrl", liveUrl);
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }
}
