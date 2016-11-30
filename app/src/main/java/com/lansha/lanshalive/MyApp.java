package com.lansha.lanshalive;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
