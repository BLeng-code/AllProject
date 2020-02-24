package com.lengbo.broadcast;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private String TAG = "LengBo";

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (action == "LengBo") {
                    Log.i(TAG, action);
                } else {
                    Log.i(TAG, action);
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();
        filter.addAction("LengBo");
        registerReceiver(mReceiver, filter);
        Intent intent = new Intent();
        intent.setAction("LengBo");
        sendBroadcast(intent);
    }
}
