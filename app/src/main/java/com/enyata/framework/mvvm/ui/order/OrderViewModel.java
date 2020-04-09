package com.enyata.framework.mvvm.ui.order;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class OrderViewModel extends BaseViewModel<OrderNavigator> {
    public OrderViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager,schedulerProvider);
    }

public  void OnOrderArrow(){
        getNavigator().backArrowOrder();
}
}
