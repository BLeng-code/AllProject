package com.lengbo.binderclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lengbo.binderservice.IService;

public class MainActivity extends AppCompatActivity {

    private IService mService;
    private EditText mData;
    private Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("com.lengbo.binderservice");
        intent.setPackage("com.lengbo.binderservice");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService = IService.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("Lengbo", "disconnected");
            }
        }, BIND_AUTO_CREATE);
        mSend = findViewById(R.id.send);
        mData = findViewById(R.id.data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mService != null) {
                    try {
                        mService.say(mData.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
