package com.lengbo.datastructure.map;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.lengbo.datastructure.R;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapActivity extends Activity {

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        
        /**
         * 整体是数组保存，数组的每一个值是一个node，node可以组成单向链表，用于解决hash冲突问题
         * */
        final HashMap<String, String> hashMap = new HashMap<>(1, 1);
        findViewById(R.id.hashMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String key = "abacedsf" + mCount;
                String value = "b" + mCount;
                hashMap.put(key, value);
            }
        });

        /**
         * 内部是简单数组，数组每个元素都是简单object
         * 声明枚举类，枚举元素作为key，
         * */
        final EnumMap enumMap = new EnumMap(Key.class);
        findViewById(R.id.enumMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String value = "b" + mCount;
                enumMap.put(Key.NO_1, value);
            }
        });


        /**
         * 内部是数组，数组元素是普通对象
         * 在判断key相等时，只考虑两个key的地址相等，不考虑equals方法
         * */
        final IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
        findViewById(R.id.hashTable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String key = "abacedsf" + mCount;
                String value = "b" + mCount;
                identityHashMap.put(key, value);
            }
        });

        /**
         * 内部是数组，数组元素是node，可以构成双向链表
         * */
        final LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(1, 1F);
        findViewById(R.id.linkedHashMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String key = "abacedsf" + mCount;
                String value = "b" + mCount;
                linkedHashMap.put(key, value);
                linkedHashMap.keySet();
                for (String str : linkedHashMap.keySet()) {
                    Object res = linkedHashMap.get(str);
                }
            }
        });

        /**
         * 内部是红黑树，每一个元素都需要实现compare接口
         * */
        final TreeMap<String, String> treeMap = new TreeMap<>();
        findViewById(R.id.treeMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String key = "abacedsf" + mCount;
                String value = "b" + mCount;
                treeMap.put(key, value);
            }
        });

        /**
         * 内部是数组，每个key都是弱引用，会被加入引用队列，在gc时可以被回收
         * */
        final WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        findViewById(R.id.weakHashMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String key = "abacedsf" + mCount;
                String value = "b" + mCount;
                weakHashMap.put(key, value);
            }
        });


        /**
         * 内部是数组，每个数组元素是一个桶，桶可以构造链表
         * 是线程安全的，不允许key或value为空
         * 锁住整个表
         * */
        final Hashtable hashtable = new Hashtable();
        findViewById(R.id.hashTable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String key = "abacedsf" + mCount;
                String value = "b" + mCount;
                hashtable.put(key, value);
            }
        });

        /**
         * 内部是segment数组，每个元素可以构成链表
         * 对某一个segment上锁
         * */
        final ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        findViewById(R.id.concurrentHashMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String key = "abacedsf" + mCount;
                String value = "b" + mCount;
                concurrentHashMap.put(key, value);
            }
        });


        /**
         * 内部是跳表，
         * */
        final ConcurrentSkipListMap<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        findViewById(R.id.concurrentSkipListMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                String key = "abacedsf" + mCount;
                String value = "b" + mCount;
                concurrentSkipListMap.put(key, value);
            }
        });

    }
}
