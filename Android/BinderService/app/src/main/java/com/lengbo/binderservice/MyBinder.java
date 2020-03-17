package com.lengbo.binderservice;

import android.os.RemoteException;

/**
 * date            2020-03-02
 * author          lengbo
 * description
 */
public class MyBinder extends IService.Stub {
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public void say(String word) throws RemoteException {

    }
}
