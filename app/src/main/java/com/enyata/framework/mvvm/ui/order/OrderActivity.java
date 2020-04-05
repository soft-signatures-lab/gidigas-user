package com.enyata.framework.mvvm.ui.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityOrderBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;

public class OrderActivity extends BaseActivity<ActivityOrderBinding, OrderViewModel> implements OrderNavigator {

    ActivityOrderBinding activityOrderBinding;
    @Inject
    ViewModelProviderFactory factory;
    OrderViewModel orderViewModel;

    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    public OrderViewModel getViewModel() {
        orderViewModel = ViewModelProviders.of(this,factory).get(OrderViewModel.class);
        return orderViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderBinding = getViewDataBinding();
        orderViewModel.setNavigator(this);

    }
}
