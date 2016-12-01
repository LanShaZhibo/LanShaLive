package com.lansha.lanshalive.Mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.lansha.lanshalive.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

@ContentView(R.layout.activity_deng_lu)
public class DengLuActivity extends AppCompatActivity implements View.OnClickListener, PlatformActionListener {

    @ViewInject(R.id.mine_btn3)
    private ImageView mWeibo;
    @ViewInject(R.id.mine_btn2)
    private ImageView mQQ;
    @ViewInject(R.id.mine_btn1)
    private ImageView mWeixin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initView();
    }

    private void initView() {
        mQQ.setOnClickListener(this);
        mWeibo.setOnClickListener(this);
        mWeixin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_btn1:
                break;
            case R.id.mine_btn2:
                login();
                break;
            case R.id.mine_btn3:
                break;
        }
    }

    private void login() {
        ShareSDK.initSDK(this);
        Platform platform = ShareSDK.getPlatform(this, QQ.NAME);
        platform.setPlatformActionListener(this);
        platform.authorize();
        platform.getId();
        platform.showUser(null);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }
}
