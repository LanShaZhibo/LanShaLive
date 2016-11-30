package com.lansha.lanshalive.Game;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.lansha.lanshalive.BaseFragment;
import com.lansha.lanshalive.GameSecondActivity;
import com.lansha.lanshalive.Model.GameData;
import com.lansha.lanshalive.R;
import com.lansha.lanshalive.adapter.GameChildAdapter;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class GameChildFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    public static final String TAG = GameChildFragment.class.getSimpleName();
    private GridView mGridView;
    private GameChildAdapter adapter;
    private String URL;

    public GameChildFragment(String URL) {
        this.URL = URL;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.game_child_fragment, container, false);
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

                    GameData gameData  = gson.fromJson(data.toString(), GameData.class);

                    adapter.updataRes(gameData.getGames());


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
        adapter = new GameChildAdapter(getActivity(), null);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), GameSecondActivity.class);
        startActivity(intent);
    }
}
