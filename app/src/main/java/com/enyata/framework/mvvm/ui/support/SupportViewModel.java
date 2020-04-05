package com.enyata.framework.mvvm.ui.support;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class SupportViewModel extends BaseViewModel<SupportNavigator> {
    public SupportViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public  void  OnArrow(){
    getNavigator().arrowClick();
    }

}
