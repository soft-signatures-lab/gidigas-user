package com.enyata.framework.mvvm.ui.map;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class MapViewModel extends BaseViewModel<MapNavigator> {
    public MapViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
    public  void OnNext(){
        getNavigator().btnNext();
    }
}
