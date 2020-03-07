package com.enyata.framework.mvvm.ui.home;

import android.util.Log;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.data.model.api.response.LoginRequest;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {

    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


    public void onDeposit(){
        getNavigator().Ondeposit();
    }
    public  void  onWithdrawal(){
        getNavigator().Onwithdrawal();
    }
    public  void onTransaction(){
        getNavigator().ontransaction();
    }


}
