/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.enyata.framework.mvvm.data;

import android.content.Context;

import com.enyata.framework.mvvm.data.local.prefs.PreferencesHelper;

import com.enyata.framework.mvvm.data.model.api.request.LoginRequest;
import com.enyata.framework.mvvm.data.model.api.request.SignUpRequest;
import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;
import com.enyata.framework.mvvm.data.model.api.response.SignUpResponse;
import com.enyata.framework.mvvm.data.model.api.response.VendorResponse;
import com.enyata.framework.mvvm.data.remote.ApiHeader;
import com.enyata.framework.mvvm.data.remote.ApiHelper;
import com.google.gson.Gson;


import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }


    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }


    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAuthorization(accessToken);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserSurname() {
        return mPreferencesHelper.getCurrentUserSurname();
    }

    @Override
    public void setCurrentUserSurname(String userSurname) {
        mPreferencesHelper.setCurrentUserSurname(userSurname);
    }

    @Override
    public String getUserEmail() {
        return mPreferencesHelper.getUserEmail();
    }

    @Override
    public void setUserEmail(String userEmail) {
mPreferencesHelper.setUserEmail(userEmail);
    }

    @Override
    public Single<SignUpResponse> signup(SignUpRequest.Request request) {
        return mApiHelper.signup(request);
    }

    @Override
    public Single<LoginResponse> login(LoginRequest.Request request) {
        return mApiHelper.login(request);
    }

    @Override
    public Flowable<VendorResponse> vendor() {
        return mApiHelper.vendor();
    }

    @Override
    public void updateUserInfo(
            String accessToken,
            String surname,
            String firstname) {

        setAccessToken(accessToken);
        setCurrentUserName(firstname);
        setCurrentUserSurname(surname);

    }

    @Override
    public void updateLoginStatus(LoggedInMode loggedInMode) {
        setCurrentUserLoggedInMode(loggedInMode);
    }
}
