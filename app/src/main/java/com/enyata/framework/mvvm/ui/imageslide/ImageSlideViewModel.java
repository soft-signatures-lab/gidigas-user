package com.enyata.framework.mvvm.ui.imageslide;

import com.enyata.framework.mvvm.data.DataManager;
import com.enyata.framework.mvvm.ui.base.BaseViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

public class ImageSlideViewModel extends BaseViewModel<ImageSlideNavigator> {
    public ImageSlideViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager,schedulerProvider);
    }
}
