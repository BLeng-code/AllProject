package com.example.dialogandpopupwindow.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.dialogandpopupwindow.R;

public class GeneralDialog extends Dialog {

    private Context mContext;
    private Builder mBuilder;
    private View mRootView;

    private GeneralDialog(Context context, Builder builder) {
        super(context);
        this.mBuilder = builder;
        this.mContext = context;
        initView();
    }


    private void initView() {
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.dialog_layout, null);
        setContentView(mRootView);
        setCanceledOnTouchOutside(false);
    }

    public void show() {
        Activity activity = (Activity) mContext;
        if (activity.isFinishing() ||
                (activity.getWindow() != null &&
                        activity.getWindow().getDecorView() != null &&
                        activity.getWindow().getDecorView().getRootView().getWindowToken() != null)) {
            try {
                super.show();
            }catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            }
        }
        Window window = getWindow();
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.x = 100;
        layoutParams.y = 100;
        window.setAttributes(layoutParams);
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public static final class Builder {
        private Context mContext;

        private Builder(Context context) {
            this.mContext = context;
        }

        public GeneralDialog build() {
            return new GeneralDialog(mContext, this);
        }
    }
}
