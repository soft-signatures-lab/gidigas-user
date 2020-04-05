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

package com.enyata.framework.mvvm.di.builder;



import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.imageslide.ImageSlideActivity;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivity;

import com.enyata.framework.mvvm.ui.map.MapsActivity;
import com.enyata.framework.mvvm.ui.order.OrderActivity;
import com.enyata.framework.mvvm.ui.splash.SplashActivity;
import com.enyata.framework.mvvm.ui.support.SupportActivity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract HomeActivity bindHomeActivity();

    @ContributesAndroidInjector
    abstract SupportActivity bindSupportActivity();

    @ContributesAndroidInjector
    abstract ImageSlideActivity bindImageSlideActivity();

    @ContributesAndroidInjector
    abstract OrderActivity bindOrderActivity();

    @ContributesAndroidInjector
    abstract MapsActivity bindMapsActivity();

}
