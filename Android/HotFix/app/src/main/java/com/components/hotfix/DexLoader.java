package com.components.hotfix;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;


public class DexLoader {
    /**
     * 加载dex文件并将dex文件插入到dex列表到最前面
     */
    public static void loadDex(Context context) {
        String dexPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/classes.dex";
        File file = new File(dexPath);
        if (file.exists()) {
            PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
            File optimizedDirectory = context.getDir("lengbo" + System.currentTimeMillis(), Context.MODE_PRIVATE);
            if (!optimizedDirectory.exists()) {
                optimizedDirectory.mkdir();
            }
            DexClassLoader dexClassLoader = new DexClassLoader(dexPath,
                    optimizedDirectory.getAbsolutePath(),
                    null,
                    pathClassLoader);
            Object pathPathList = getPathList(pathClassLoader);
            Object dexPathList = getPathList(dexClassLoader);
            Object pathDexElements = getDexElements(pathPathList);
            Object dexDexElements = getDexElements(dexPathList);

            Object value = combineDex(dexDexElements, pathDexElements);
            setField(pathPathList.getClass(), pathPathList, "dexElements", value);
        } else {
            System.out.println("dex 不存在");
        }
    }

    /**
     * 获取pathList对象，classLoader从该对象中读取dex
     */
    public static Object getPathList(BaseDexClassLoader classLoader) {
        try {
            Class clazz = Class.forName("dalvik.system.BaseDexClassLoader");
            return getField(clazz, classLoader, "pathList");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取dex对象，该对象存放在pathList对象之中
     */
    public static Object getDexElements(Object pathList) {
        Class clazz = pathList.getClass();
        return getField(clazz, pathList, "dexElements");
    }

    /**
     * 通过反射获取某个对象的某个域对象
     */
    public static Object getField(Class clazz, Object object, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置某个对象的域值
     */
    public static void setField(Class clazz, Object object, String fieldName, Object value) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 合并dex文件，将修复的dex放在整个dex之前
     */
    public static Object combineDex(Object fixDexElements, Object baseDexElements) {
        int length1 = Array.getLength(fixDexElements);
        int length2 = Array.getLength(baseDexElements) + length1;
        Object instance = Array.newInstance(fixDexElements.getClass().getComponentType(), length2);
        for (int i = 0; i < length2; i++) {
            if (i < length1) {
                Array.set(instance, i, Array.get(fixDexElements, i));
            } else {
                Array.set(instance, i, Array.get(baseDexElements, i - length1));
            }
        }
        return instance;
    }
}
