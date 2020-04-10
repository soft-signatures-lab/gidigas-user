package com.enyata.framework.mvvm.ui.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityCartBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.orderinfo.OrderInfoActivity;

import javax.inject.Inject;

public class CartActivity extends BaseActivity<ActivityCartBinding, CartViewModel> implements CartNavigator{
@Inject
    ViewModelProviderFactory factory;
ActivityCartBinding activityCartBinding;
CartViewModel cartViewModel;
ToggleButton btn1, btn2;
LinearLayout linearLayout;
ImageView cart;
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
        cart = activityCartBinding.arrowCart;
        btn1 = activityCartBinding.onDelivery;
        btn2 = activityCartBinding.OnPayment;
        linearLayout = activityCartBinding.onlineInfo;


        btn2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                linearLayout.setVisibility(View.VISIBLE);
            } else {
                linearLayout.setVisibility(View.GONE);
            }
        });

        cart.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), OrderInfoActivity.class);
            startActivity(intent);

        });
    }


}
