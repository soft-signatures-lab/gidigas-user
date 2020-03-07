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

package com.enyata.framework.mvvm.data.remote;


import com.enyata.framework.mvvm.data.model.api.response.LoginRequest;
import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;
import com.enyata.framework.mvvm.data.model.api.response.UserColorResponse;
import com.enyata.framework.mvvm.data.model.api.response.UserResponse;
import com.enyata.framework.mvvm.data.model.api.response.UsersRequest;
import com.enyata.framework.mvvm.data.model.api.response.UsersResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Flowable;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by amitshekhar on 07/07/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }


    @Override
    public Single<LoginResponse> login(LoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.SUPER_AGENT_LOGIN)
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<UsersResponse> user(UsersRequest request) {
        return Rx2AndroidNetworking.put(ApiEndPoint.SUPER_AGENT_PUT)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(UsersResponse.class);
    }


    @Override
    public Flowable<UserColorResponse> colors() {
        return Rx2AndroidNetworking.get(ApiEndPoint.SUPER_AGENT_COLORS)
                .build()
                .getObjectFlowable(UserColorResponse.class);
    }


    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }


}
