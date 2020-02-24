package com.lengbo.binderservice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lengbo.binderservice.R;
import com.lengbo.binderservice.presenter.ShowPresenter;

public class ShowActivity extends Activity implements IShow{

    private TextView mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ShowPresenter.getInstance().setShow(this);
        mData = findViewById(R.id.data);
    }

    @Override
    public void showData(String data) {
        mData.setText(data);
    }
}
