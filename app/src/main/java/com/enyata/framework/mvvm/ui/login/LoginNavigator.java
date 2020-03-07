package com.enyata.framework.mvvm.ui.login;

import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;

public interface LoginNavigator {
    void onlogin();
    void getPin();
    void handleError(Throwable throwable);
    void onLogin(LoginResponse LOG);
}
