package com.lengbo.binderservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.lengbo.binderservice.presenter.ShowPresenter;

import androidx.annotation.Nullable;

/**
 * date            2020-02-21
 * author          lengbo
 * description
 */
public class MyService extends Service {
    private String TAG = "Service";

    private IBinder mBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
