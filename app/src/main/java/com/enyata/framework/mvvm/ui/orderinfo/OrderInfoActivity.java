package com.enyata.framework.mvvm.ui.orderinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityOrderInfoBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.cart.CartActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.map.MapsActivity;

import javax.inject.Inject;

public class OrderInfoActivity extends BaseActivity<ActivityOrderInfoBinding, OrderInfoViewModel> implements OrderInfoNavigator {
@Inject
    ViewModelProviderFactory factory;
ActivityOrderInfoBinding activityOrderInfoBinding;
OrderInfoViewModel orderInfoViewModel;
ImageView orderInfo;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_info;
    }

    @Override
    public OrderInfoViewModel getViewModel() {
        orderInfoViewModel = ViewModelProviders.of(this,factory).get(OrderInfoViewModel.class);
        return orderInfoViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderInfoBinding = getViewDataBinding();
       orderInfoViewModel.setNavigator(this);

       orderInfo = activityOrderInfoBinding.OrderInfo;

       orderInfo.setOnClickListener(view -> {
           Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
           startActivity(intent);
       });
    }

    @Override
    public void cart() {
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        startActivity(intent);
    }
}
