package com.lansha.lanshalive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class GameFragment extends BaseFragment{
    public static final String TAG = GameFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.game_fragment,container,false);
        return layout;
    }
}
