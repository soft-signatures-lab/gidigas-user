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

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by amitshekhar on 07/07/17.
 */

public interface ApiHelper {

    Single<LoginResponse> login(LoginRequest request);
    Single<UsersResponse> user(UsersRequest request);
    Flowable<UserColorResponse> colors();
    ApiHeader getApiHeader();

}
