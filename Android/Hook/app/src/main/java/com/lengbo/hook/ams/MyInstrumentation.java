package com.lengbo.hook.ams;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * date            2020-03-03
 * author          lengbo
 * description
 */
public class MyInstrumentation extends Instrumentation {

    private String TAG = "LengBo";

    private Instrumentation mOrigin;

    public MyInstrumentation(Instrumentation instrumentation) {
        mOrigin = instrumentation;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {
        Log.i(TAG, "hook execStartActivity 方法");
        try {
            Class instrumentationClass = Class.forName("android.app.Instrumentation");
            Method execStartActivityMethod = instrumentationClass.getDeclaredMethod("execStartActivity",
                    Context.class, IBinder.class, IBinder.class, Activity.class,
                    Intent.class, int.class, Bundle.class);
            execStartActivityMethod.setAccessible(true);
            return (ActivityResult) execStartActivityMethod.invoke(mOrigin, who, contextThread, token, target, intent, requestCode, options);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Activity newActivity(ClassLoader cl, String className,
                                Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Log.i(TAG, "创建应用的第一个activity");
        return mOrigin.newActivity(cl, className, intent);
    }

}