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

    private IBinder mBinder = new IService.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void say(String word) throws RemoteException {
            ShowPresenter.getInstance().showData(word);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
