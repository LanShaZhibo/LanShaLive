package com.lansha.lanshalive.Game;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lansha.lanshalive.BaseFragment;
import com.lansha.lanshalive.Model.GameSeconVideo.VideoData;
import com.lansha.lanshalive.R;
import com.lansha.lanshalive.adapter.GameSecondVideoAdapter;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Wind on 2016/11/30 0030.
 */
public class GameSecondVideoFragment extends BaseFragment {

    public static final String TAG = GameSecondVideoFragment.class.getSimpleName();
    private ListView mListView;
    private GameSecondVideoAdapter adapter;
    private String URL;

    public GameSecondVideoFragment(String URL) {
        this.URL = URL;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.game_second_video_fragment,container,false);
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

                    VideoData videoData  = gson.fromJson(data.toString(), VideoData.class);

                    adapter.updataRes(videoData.getList());

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
        mListView = (ListView) layout.findViewById(R.id.game_second_video_vp_lv);
        adapter = new GameSecondVideoAdapter(getActivity(),null);
        mListView.setAdapter(adapter);
    }
}
