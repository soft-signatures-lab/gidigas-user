package com.enyata.framework.mvvm.ui.mainActivity;

import android.text.TextUtils;
import android.util.Log;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.data.model.api.request.LoginRequest;
import com.enyata.framework.mvvm.data.model.api.request.SignUpRequest;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.CommonUtils;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class MainActivityViewModel extends BaseViewModel<MainNavigator> {
    public MainActivityViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        return !TextUtils.isEmpty(email) && CommonUtils.isEmailValid(email) && !TextUtils.isEmpty(password);
    }


    public static boolean checkIfFieldAreNotEmpty(String surname, String phone, String email, String password, String firstname) {
        if (TextUtils.isEmpty(surname) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(firstname)) {
            return false;
        }

        return true;
    }

    public boolean isLengthEqualsToSeven(String password) {
        return password.length() >= 5;
    }

    public void signUp(String surname, String phone, String email, String password, String firstname, String fcmtoken) {

        setIsLoading(true);
        getCompositeDisposable().add((getDataManager()
                .signup(new SignUpRequest.Request(surname, phone, email, password, firstname, fcmtoken))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    String userName = response.getData().getFirstname();
                    String userSurname =response.getData().getSurname();
                    String token = response.getAccessToken();
                    getDataManager().updateUserInfo(token,userName,userSurname);
                            setIsLoading(false);
                            getNavigator().onSignUp(response);
                        }, throwable -> {
                            Log.d("An error occured", String.valueOf(throwable.getMessage()));
                            setIsLoading(false);
                            getNavigator().handleError(throwable);
                        }
                )));
    }

    public void login(String email, String password,String uuid) {
        setIsLoading(true);
        getCompositeDisposable().add((getDataManager()
                .login(new LoginRequest.Request(email, password,uuid))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                            setIsLoading(false);
                    getDataManager().updateLoginStatus(DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_IN);
                            String userName = response.getLoginData().getFirstname();
                            String userSurname = response.getLoginData().getSurname();
                            String token = response.getAccessToken();
                            getDataManager().updateUserInfo(token,userName,userSurname);
                            Log.d("token",response.getAccessToken());
                            getNavigator().onLogin(response);
                        }, throwable -> {
                            Log.d("Login  error", String.valueOf(throwable.getMessage()));
                            setIsLoading(false);
                            getNavigator().handleError(throwable);
                        }
                )));
    }




}
