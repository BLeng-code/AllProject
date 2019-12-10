package com.baidu.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.baidu.listview.adpter.ListViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            data.add(i + "item");
        }
        ListViewAdapter adapter = new ListViewAdapter(this, data);
        container.setAdapter(adapter);
    }
}
