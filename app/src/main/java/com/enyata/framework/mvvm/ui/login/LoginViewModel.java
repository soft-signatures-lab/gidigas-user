package com.enyata.framework.mvvm.ui.login;

import android.text.TextUtils;
import android.util.Log;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.data.model.api.response.LoginRequest;
import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;


public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    LoginResponse response;

    public void onLogin() {
        getNavigator().onlogin();

    }
    public static boolean isEmailAndPasswordValid(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password) {
        setIsLoading(true);
        getCompositeDisposable().add((getDataManager()
                .login(new LoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().onLogin(response);

                    getNavigator().getPin();
                }, throwable -> {
                    Log.d("ERROR ", String.valueOf(throwable.getMessage()));
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                })));

    }
}
