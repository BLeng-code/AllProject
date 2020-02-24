package com.lengbo.main;

import android.app.Application;

import com.lengbo.data.sp.SharePreferenceUtil;

/**
 * date            2020-02-09
 * author          lengbo
 * description
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharePreferenceUtil.deal();
    }
}
