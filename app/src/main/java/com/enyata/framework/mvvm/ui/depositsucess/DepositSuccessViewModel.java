package com.enyata.framework.mvvm.ui.depositsucess;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class DepositSuccessViewModel extends BaseViewModel<DepositSuccessNavigator> {
    public DepositSuccessViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public  void onHome(){
        getNavigator().onhome();
    }
    public void onArrowHome(){
        getNavigator().arrowhome();
    }
}
