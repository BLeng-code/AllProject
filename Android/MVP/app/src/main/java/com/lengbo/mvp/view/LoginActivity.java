package com.lengbo.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lengbo.mvp.R;
import com.lengbo.mvp.model.LoginModel;
import com.lengbo.mvp.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText mUserName;
    private EditText mPassword;
    private Button mLogin;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserName = findViewById(R.id.user_name);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);

        mLoginPresenter = new LoginPresenter(this, new LoginModel());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = mUserName.getText().toString();
                String password = mPassword.getText().toString();
                mLoginPresenter.login(userName, password);
            }
        });
    }

    @Override
    public void success() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void failed() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_LONG).show();
    }
}
