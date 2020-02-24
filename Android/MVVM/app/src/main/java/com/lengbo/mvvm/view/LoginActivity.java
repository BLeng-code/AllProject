package com.lengbo.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.lengbo.mvvm.R;
import com.lengbo.mvvm.databinding.ActivityLoginBinding;
import com.lengbo.mvvm.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel loginViewModel = new LoginViewModel("", "");
        binding.setUser(loginViewModel);
    }
}
