package com.enyata.framework.mvvm.ui.deposit;

import android.util.Log;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.data.model.api.response.LoginRequest;
import com.enyata.framework.mvvm.data.model.api.response.UsersRequest;
import com.enyata.framework.mvvm.data.model.api.response.UsersResponse;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class DepositViewModel extends BaseViewModel<DepositNavigator> {
    public DepositViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void  arrowDeposit(){
        getNavigator().backArrow();
    }
    public void onDepositPin(){
        getNavigator().ondepositpin();
    }

    public void user(String name, String job ) {
        setIsLoading(true);
        getCompositeDisposable().add((getDataManager()
                .user(new UsersRequest(name, job))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().getUser(response);
                    getNavigator().Depositpin();


                }, throwable -> {
                    Log.d("ERROR ", String.valueOf(throwable.getMessage()));
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                })));

    }
}
