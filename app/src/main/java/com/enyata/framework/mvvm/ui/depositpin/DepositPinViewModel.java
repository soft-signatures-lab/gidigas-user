package com.enyata.framework.mvvm.ui.depositpin;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class DepositPinViewModel extends BaseViewModel<DepositPinNavigator> {

    public DepositPinViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onDepositSuccess(){
        getNavigator().ondepositsuccess();
    }
    public  void  arrowDepositSuccess(){
        getNavigator().arrowdepositsuccess();
    }
}
