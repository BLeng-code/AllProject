package com.lengbo.mvp.presenter;

import com.lengbo.mvp.model.LoginModel;
import com.lengbo.mvp.view.ILoginView;

/**
 * date            2020-02-18
 * author          lengbo
 * description
 */
public class LoginPresenter implements LoginModel.ILoginCallback {
    private ILoginView mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenter(ILoginView loginView, LoginModel loginModel) {
        mLoginView = loginView;
        mLoginModel = loginModel;
    }

    public void login(String userName, String password) {
        if (mLoginModel != null) {
            mLoginModel.login(userName, password, this);
        }
    }

    @Override
    public void success() {
        if (mLoginView != null) {
            mLoginView.success();
        }
    }

    @Override
    public void failed() {
        if (mLoginView != null) {
            mLoginView.failed();
        }
    }
}
