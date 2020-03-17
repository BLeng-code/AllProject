package com.lengbo.plugin;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * date            2020-03-01
 * author          lengbo
 * description
 */
public class PluginApplication extends Application {



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // 先获取到当前的ActivityThread对象
        Class<?> activityThreadClass = null;
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
        currentActivityThreadMethod.setAccessible(true);
        Object currentActivityThread = null;
        try {
            currentActivityThread = currentActivityThreadMethod.invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 拿到原始的 mInstrumentation字段
        Field mInstrumentationField = null;
        try {
            mInstrumentationField = activityThreadClass.getDeclaredField("mInstrumentation");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        mInstrumentationField.setAccessible(true);
        Instrumentation mInstrumentation = null;
        try {
            mInstrumentation = (Instrumentation) mInstrumentationField.get(currentActivityThread);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // 创建代理对象
        Instrumentation evilInstrumentation = new PluginInstrumentation(mInstrumentation);

        // 偷梁换柱
        try {
            mInstrumentationField.set(currentActivityThread, evilInstrumentation);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
