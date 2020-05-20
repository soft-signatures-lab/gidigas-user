package com.enyata.framework.mvvm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.enyata.framework.mvvm.data.DataManager;


import com.enyata.framework.mvvm.ui.addaddress.AddAddressViewModel;
import com.enyata.framework.mvvm.ui.addcard.AddcardViewModel;
import com.enyata.framework.mvvm.ui.address.AddressActivity;
import com.enyata.framework.mvvm.ui.address.AddressViewModel;
import com.enyata.framework.mvvm.ui.cart.CartViewModel;
import com.enyata.framework.mvvm.ui.home.HomeViewModel;
import com.enyata.framework.mvvm.ui.imageslide.ImageSlideViewModel;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivityViewModel;
import com.enyata.framework.mvvm.ui.map.MapViewModel;
import com.enyata.framework.mvvm.ui.map.MapsActivity;
import com.enyata.framework.mvvm.ui.order.OrderViewModel;
import com.enyata.framework.mvvm.ui.orderinfo.OrderInfoViewModel;
import com.enyata.framework.mvvm.ui.payment.PaymentViewModel;
import com.enyata.framework.mvvm.ui.splash.SplashViewModel;
import com.enyata.framework.mvvm.ui.support.SupportViewModel;
import com.enyata.framework.mvvm.ui.vendor.VendorViewModel;
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
        }else if (modelClass.isAssignableFrom(AddressViewModel.class)) {
            //noinspection unchecked
            return (T) new AddressViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(PaymentViewModel.class)) {
            //noinspection unchecked
            return (T) new PaymentViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(AddcardViewModel.class)) {
            //noinspection unchecked
            return (T) new AddcardViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(AddAddressViewModel.class)) {
            //noinspection unchecked
            return (T) new AddAddressViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(OrderInfoViewModel.class)) {
            //noinspection unchecked
            return (T) new OrderInfoViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(CartViewModel.class)) {
            //noinspection unchecked
            return (T) new CartViewModel(dataManager, schedulerProvider);
        }else if (modelClass.isAssignableFrom(VendorViewModel.class)) {
            //noinspection unchecked
            return (T) new VendorViewModel(dataManager, schedulerProvider);
        }


        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}