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

import com.enyata.framework.mvvm.ui.confirmationpage.ConfirmationPageActivity;
import com.enyata.framework.mvvm.ui.confirmationsuccess.ConfirmSuccessActivity;
import com.enyata.framework.mvvm.ui.deposit.DepositActivity;
import com.enyata.framework.mvvm.ui.depositpin.DepositPinActivity;
import com.enyata.framework.mvvm.ui.depositsucess.DepositSuccessActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.login.LoginActivity;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivity;
import com.enyata.framework.mvvm.ui.setPin.SetPinActivity;
import com.enyata.framework.mvvm.ui.splash.SplashActivity;
import com.enyata.framework.mvvm.ui.transactionhistory.TransactionHistoryActivity;
import com.enyata.framework.mvvm.ui.withdrawal.WithdrawalActivity;
import com.enyata.framework.mvvm.ui.withdrawalpin.WithdrawalPinActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector
    abstract SetPinActivity bindSetPinActivity();

    @ContributesAndroidInjector
    abstract HomeActivity bindHomeActivity();

    @ContributesAndroidInjector
    abstract ConfirmationPageActivity bindConfirmationPageActivity();

    @ContributesAndroidInjector
    abstract ConfirmSuccessActivity bindConfirmSuccessActivity();

    @ContributesAndroidInjector
    abstract DepositActivity bindDepositActivity();

    @ContributesAndroidInjector
    abstract DepositPinActivity bindDepositPinActivity();

    @ContributesAndroidInjector
    abstract DepositSuccessActivity bindDepositSuccessActivity();

    @ContributesAndroidInjector
    abstract WithdrawalActivity bindWithdrawalActivity();

    @ContributesAndroidInjector
    abstract WithdrawalPinActivity bindWithdrawalPinActivity();

    @ContributesAndroidInjector
    abstract TransactionHistoryActivity bindTransactionHistoryActivity();

}
