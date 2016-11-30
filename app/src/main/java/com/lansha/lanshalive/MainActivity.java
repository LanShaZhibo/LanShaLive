package com.lansha.lanshalive;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup mController;
    private ImageView mPlay;
    private Fragment showFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mController = (RadioGroup) findViewById(R.id.main_controller);
        mController.setOnCheckedChangeListener(this);

        mPlay = (ImageView) findViewById(R.id.teach_play);
        mPlay.setOnClickListener(this);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();


        showFragment = new HomePageFragment();
        transaction.add(R.id.main_fragment,showFragment,HomePageFragment.TAG);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_homepage:
                switchPage(HomePageFragment.TAG,HomePageFragment.class);
                break;
            case R.id.main_game:
                switchPage(GameFragment.TAG,GameFragment.class);
                break;
            case R.id.main_live:
                switchPage(LiveFragment.TAG,LiveFragment.class);
                break;
            case R.id.main_mine:
                switchPage(MineFragment.TAG,MineFragment.class);
                break;

        }
    }

    private  void switchPage(String tag,Class<?extends Fragment> cls){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //隐藏当前显示界面
        transaction.hide(showFragment);
        //显示点击的页面
        //去Fragemnt栈中查找
        showFragment = fm.findFragmentByTag(tag);

        if (showFragment != null){
            transaction.show(showFragment);
        }else {
            //实例化一个页面，显示出来，并存到showFragment
            try {
                showFragment = cls.getConstructor().newInstance();
                transaction.add(R.id.main_fragment,showFragment,tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        //中间按钮功能预留
    }

}
