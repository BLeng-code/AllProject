package com.lengbo.hook;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.util.Log;

import com.lengbo.hook.ams.MyInstrumentation;
import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.XC_MethodReplacement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * date            2020-03-03
 * author          lengbo
 * description
 */
public class MyApplication extends Application {
    private String TAG = "LengBo";

    public MyApplication() {
        super();
        if (DexposedBridge.canDexposed(this)) {
            DexposedBridge.findAndHookMethod(MainActivity.class, "set", new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                            Log.i(TAG, "替换");
                            return null;
                        }
                    }

            );
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        Log.i(TAG, "attachBaseContext");
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Class activityThreadClass = null;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method currentActivityThreadMethod = null;
        try {
            currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Object currentActiivtyThread = null;
        try {
            currentActiivtyThread = currentActivityThreadMethod.invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Field mInstrumentationField = null;
        try {
            mInstrumentationField = activityThreadClass.getDeclaredField("mInstrumentation");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        mInstrumentationField.setAccessible(true);
        Instrumentation origin = null;
        try {
            origin = (Instrumentation) mInstrumentationField.get(currentActiivtyThread);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        MyInstrumentation myInstrumentation = new MyInstrumentation(origin);
        try {
            mInstrumentationField.set(currentActiivtyThread, myInstrumentation);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
