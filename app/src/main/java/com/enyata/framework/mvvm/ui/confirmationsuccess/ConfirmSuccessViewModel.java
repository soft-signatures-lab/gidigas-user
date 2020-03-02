package com.enyata.framework.mvvm.ui.confirmationsuccess;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class ConfirmSuccessViewModel extends BaseViewModel<ConfirmSuccessNavigator> {
    public ConfirmSuccessViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public  void arrow2(){
        getNavigator().arrow2();
    }
    public void ConfirmHome(){
        getNavigator().Confirmhome();
    }
}
