package com.enyata.framework.mvvm.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;

import com.androidnetworking.error.ANError;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;
import com.enyata.framework.mvvm.databinding.ActivityLoginBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.setPin.SetPinActivity;
import com.google.gson.Gson;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {

    @Inject
    Gson gson;

    @Inject
    ViewModelProviderFactory factory;
    private LoginViewModel loginViewModel;
    private ActivityLoginBinding mActivityLoginBinding;

    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        loginViewModel = ViewModelProviders.of(this,factory).get(LoginViewModel.class);
        return loginViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        loginViewModel.setNavigator(this);
    }



    @Override
    public void onlogin() {
            String email = mActivityLoginBinding.email.getText().toString();
            String password = mActivityLoginBinding.password.getText().toString();
            if (LoginViewModel.isEmailAndPasswordValid(email, password)) {
                hideKeyboard();
                loginViewModel.login(email, password);
            } else {
                Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    public void getPin() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void handleError(Throwable throwable) {
        if (throwable != null) {
            ANError error = (ANError) throwable;

            LoginResponse response = gson.fromJson(error.getErrorBody(), LoginResponse.class);
            if (error.getErrorBody()!= null){
                Toast.makeText(getApplicationContext(), "there's something wrong", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "Unable to connect to the Internet", Toast.LENGTH_LONG).show();
            }
        }
        }

    @Override
    public void onLogin(LoginResponse LOG) {
        Toast.makeText(getApplicationContext(), "successful" + LOG.getAccessToken(), Toast.LENGTH_LONG).show();
    }
}