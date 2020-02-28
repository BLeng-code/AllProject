package com.lengbo.fourcomponents.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.lengbo.fourcomponents.R;
import com.lengbo.fourcomponents.broadcast.AReceiver;
import com.lengbo.fourcomponents.service.AService;

public class AActivity extends AppCompatActivity {

    private String TAG = "LengBo";
    private Messenger messenger;
    private AReceiver mReceiver;

    private LocalBroadcastManager mLocalBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Intent intent = new Intent(AActivity.this, AService.class);
        startService(intent);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i(TAG, "CONNECTED");
                messenger = new Messenger(service);

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = Message.obtain();
                message.what = 1;
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        Intent intent1 = new Intent("action");
        sendBroadcast(intent);

        sendOrderedBroadcast(intent, null);

        mReceiver = new AReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("action");
        filter.setPriority(100);

        registerReceiver(mReceiver, filter);
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mLocalBroadcastManager.registerReceiver(mReceiver, filter);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
        mLocalBroadcastManager.unregisterReceiver(mReceiver);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
