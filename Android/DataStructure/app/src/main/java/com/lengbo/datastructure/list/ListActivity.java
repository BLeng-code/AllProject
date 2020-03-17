package com.lengbo.datastructure.list;


import android.app.Activity;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.View;

import com.lengbo.datastructure.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        /**
         * 内部是数组
         * */
        final ArrayList arrayList = new ArrayList();
        findViewById(R.id.arrayList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(1);
                arrayList.remove(0);
            }
        });

        /**
         * 内部是链表
         * */
        final LinkedList linkedList = new LinkedList();
        findViewById(R.id.linkedList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkedList.add(1);
                linkedList.remove(0);
            }
        });

        /**
         * 线程安全的数组
         * */
        final Vector vector = new Vector();
        findViewById(R.id.vector).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vector.add(1);
                vector.remove(0);
            }
        });

        /**
         * 内部是vector，线程安全 后进先出
         * */
        final Stack stack = new Stack();
        findViewById(R.id.stack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stack.push(1);
                stack.pop();
            }
        });

        /**
         * 内部是数组，线程安全 写时复制
         * */
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        findViewById(R.id.copyOnWriteArrayList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                copyOnWriteArrayList.add(1);
            }
        });
    }
}
