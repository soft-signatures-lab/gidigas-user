package com.enyata.framework.mvvm.ui.orderinfo;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class OrderInfoViewModel extends BaseViewModel<OrderInfoNavigator> {
    public OrderInfoViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public void OnCart(){
        getNavigator().cart();
    }
}
