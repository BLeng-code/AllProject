package com.lengbo.mvp.model;

/**
 * date            2020-02-18
 * author          lengbo
 * description
 */
public class LoginModel {
    public interface ILoginCallback {
        void success();

        void failed();
    }

    public void login(String userName, String password, ILoginCallback callback) {
        if (callback != null
                && userName != null
                && password != null) {
            callback.success();
        } else if (callback != null) {
            callback.failed();
        }
    }

}
