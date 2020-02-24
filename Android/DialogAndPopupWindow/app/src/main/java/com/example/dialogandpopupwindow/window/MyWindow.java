package com.example.dialogandpopupwindow.window;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.dialogandpopupwindow.R;

public class MyWindow extends PopupWindow {

    private Context mContext;
    private View mRootView;

    private MyWindow(Context context) {
        mContext = context;
        initView();
    }

    private void initView() {
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.window_layout, null);
        setContentView(mRootView);
        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        setFocusable(true);
        Button btn1 = mRootView.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "btn1", Toast.LENGTH_LONG).show();
            }
        });

        Button btn2 = mRootView.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "btn2", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public static final class Builder {
        private Context mContext;

        private Builder(Context context) {
            mContext = context;
        }

        public MyWindow build() {
            return new MyWindow(mContext);
        }
    }
}
