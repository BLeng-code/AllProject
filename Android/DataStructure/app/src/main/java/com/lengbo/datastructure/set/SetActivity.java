package com.lengbo.datastructure.set;


import android.app.Activity;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.View;

import com.lengbo.datastructure.R;
import com.lengbo.datastructure.map.Key;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        /**
         * 包含两个数组，一个存放value的hash值，一个存放value
         * */
        final ArraySet arraySet = new ArraySet();
        findViewById(R.id.arraySet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                arraySet.add(1);
            }
        });
        final HashSet hashSet = new HashSet();

        /**
         * 使用hashmap存放数据
         * */
        findViewById(R.id.hashSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hashSet.add(1);
            }
        });

        /**
         * 使用linkedhashmap存储数据
         * */
        final LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        findViewById(R.id.linkedHashSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkedHashSet.add("abc");
            }
        });

        /**
         * 使用enum
         * */
        final EnumSet enumSet = EnumSet.noneOf(Key.class);

        findViewById(R.id.enumSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enumSet.add(Key.NO_1);
            }
        });


        /**
         * 使用treemap保存数据
         * */
        final TreeSet treeSet = new TreeSet<String>();

        findViewById(R.id.treeSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                treeSet.add("abc");
            }
        });

        /**
         * 内部是CopyOnWriteArrayList，线程安全
         * */
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        findViewById(R.id.copyOnWriteArraySet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyOnWriteArraySet.add("abc");
            }
        });
    }
}
