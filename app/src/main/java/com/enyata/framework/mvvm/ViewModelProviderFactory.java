package com.enyata.framework.mvvm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.enyata.framework.mvvm.data.DataManager;


import com.enyata.framework.mvvm.ui.home.HomeViewModel;
import com.enyata.framework.mvvm.ui.imageslide.ImageSlideViewModel;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivityViewModel;
import com.enyata.framework.mvvm.ui.map.MapViewModel;
import com.enyata.framework.mvvm.ui.map.MapsActivity;
import com.enyata.framework.mvvm.ui.order.OrderViewModel;
import com.enyata.framework.mvvm.ui.splash.SplashViewModel;
import com.enyata.framework.mvvm.ui.support.SupportViewModel;
import com.enyata.framework.mvvm.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            //noinspection unchecked
            return (T) new MainActivityViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            //noinspection unchecked
            return (T) new HomeViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(SupportViewModel.class)) {
            //noinspection unchecked
            return (T) new SupportViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(ImageSlideViewModel.class)) {
            //noinspection unchecked
            return (T) new ImageSlideViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(OrderViewModel.class)) {
            //noinspection unchecked
            return (T) new OrderViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(MapViewModel.class)) {
            //noinspection unchecked
            return (T) new MapViewModel(dataManager, schedulerProvider);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}