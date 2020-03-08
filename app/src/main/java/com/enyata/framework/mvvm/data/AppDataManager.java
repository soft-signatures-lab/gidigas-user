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
import com.enyata.framework.mvvm.data.model.api.response.UserColorResponse;
import com.enyata.framework.mvvm.data.model.api.response.UserResponse;
import com.enyata.framework.mvvm.data.model.api.response.UsersRequest;
import com.enyata.framework.mvvm.data.model.api.response.UsersResponse;
import com.enyata.framework.mvvm.data.model.others.QuestionCardData;
import com.enyata.framework.mvvm.data.remote.ApiHeader;
import com.enyata.framework.mvvm.data.remote.ApiHelper;
import com.google.gson.Gson;
import com.enyata.framework.mvvm.data.model.api.response.LoginRequest;
import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;
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
    public Single<LoginResponse> login(LoginRequest request) {
        return mApiHelper.login(request);
    }

    @Override
    public Single<UsersResponse> user(UsersRequest request) {
        return mApiHelper.user(request);
    }


    @Override
    public Flowable<UserColorResponse> colors() {
        return mApiHelper.colors();
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }


    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }
}
