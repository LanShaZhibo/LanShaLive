package com.lansha.lanshalive;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lansha.lanshalive.Mine.DengLuActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Wind on 2016/11/28 0028.
 */
@ContentView(R.layout.mine_fragment)
public class MineFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = MineFragment.class.getSimpleName();
    @ViewInject(R.id.linear1)
    private LinearLayout mLinear1;
    @ViewInject(R.id.linear2)
    private LinearLayout mLinear2;
    @ViewInject(R.id.linear3)
    private LinearLayout mLinear3;
    @ViewInject(R.id.linear4)
    private LinearLayout mLinear4;
    @ViewInject(R.id.linear5)
    private LinearLayout mLinear5;
    @ViewInject(R.id.linear6)
    private LinearLayout mLinear6;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }

    private void initView() {
        mLinear1.setOnClickListener(this);
        mLinear2.setOnClickListener(this);
        mLinear3.setOnClickListener(this);
        mLinear4.setOnClickListener(this);
        mLinear5.setOnClickListener(this);
        mLinear6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), DengLuActivity.class);
        switch (v.getId()) {
            case R.id.linear1:
                    startActivity(intent);
                break;
            case R.id.linear2:
                startActivity(intent);
                break;
            case R.id.linear3:
                startActivity(intent);
                break;
            case R.id.linear4:
                startActivity(intent);
                break;
            case R.id.linear5:
                startActivity(intent);
                break;
            case R.id.linear6:
                break;
        }
    }
}

