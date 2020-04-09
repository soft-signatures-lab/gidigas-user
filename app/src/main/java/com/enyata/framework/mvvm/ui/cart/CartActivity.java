package com.enyata.framework.mvvm.ui.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityCartBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;

import javax.inject.Inject;

public class CartActivity extends BaseActivity<ActivityCartBinding, CartViewModel> implements CartNavigator{
@Inject
    ViewModelProviderFactory factory;
ActivityCartBinding activityCartBinding;
CartViewModel cartViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cart;
    }

    @Override
    public CartViewModel getViewModel() {
        cartViewModel = ViewModelProviders.of(this,factory).get(CartViewModel.class);
        return cartViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCartBinding = getViewDataBinding();
        cartViewModel.setNavigator(this);
    }
}
