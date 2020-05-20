package com.enyata.framework.mvvm.ui.mainActivity;

import androidx.viewpager.widget.ViewPager;

import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;
import com.enyata.framework.mvvm.data.model.api.response.SignUpResponse;

public interface MainNavigator {

    ViewPager getViewPager();
    void onSignUp(SignUpResponse response);
    void handleError(Throwable throwable);
    void onLogin(LoginResponse response);

}
