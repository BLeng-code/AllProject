package com.lengbo.mvvm.viewmodel;

import android.view.View;
import android.widget.Toast;

import com.lengbo.mvvm.model.UserModel;

/**
 * date            2020-02-18
 * author          lengbo
 * description
 */
public class LoginViewModel {
    private String mUserName;
    private String mPassword;
    private UserModel mUserModel;

    public LoginViewModel(String mUserName, String mPassword) {
        this.mUserName = mUserName;
        this.mPassword = mPassword;
    }

    public void login(final View view) {
        mUserModel = new UserModel();
        mUserModel.login(mUserName, mPassword, new UserModel.IUserModel() {
            @Override
            public void callback() {
                Toast.makeText(view.getContext(), "登录成功", Toast.LENGTH_LONG).show();
            }
        });
    }

    public String getMUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getMPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
