package com.lengbo.mvvm.model;

/**
 * date            2020-02-18
 * author          lengbo
 * description
 */
public class UserModel {


    public interface IUserModel {
        void callback();
    }

    public void login(String userName, String password, IUserModel callback){
        if (callback != null) {
            callback.callback();
        }
    }
}
