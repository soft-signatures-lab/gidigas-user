package com.enyata.framework.mvvm.ui.home;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {
    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void OnHelp(){
        getNavigator().onhelp();
    }

    public void onOrder(){
        getNavigator().onorder();
    }

}
