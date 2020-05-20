package com.enyata.framework.mvvm.ui.orderinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
ImageView angleA;
ImageView angleB;
TextView kilo;
    int i = 0;
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
        angleA = activityOrderInfoBinding.angle1;
        angleB = activityOrderInfoBinding.angle2;

        kilo = activityOrderInfoBinding.kiloGram;


        angleB.setOnClickListener(view -> {
            //angleB.setColorFilter(getResources().getColor(R.color.bluish));
            if (kilo.getText().toString().equals("0")) {
                kilo.setText("3kg");
                angleA.setVisibility(View.VISIBLE);

            } else if (kilo.getText().toString().equals("3kg")) {
                kilo.setText("5kg");
            } else if (kilo.getText().toString().equals("5kg")) {
                kilo.setText("7kg");
            } else {
                kilo.setText("12.5kg");
            }


        });

        angleA.setOnClickListener(view -> {
           // angleA.setColorFilter(getResources().getColor(R.color.bluish));
            //angleB.setColorFilter(getResources().getColor(R.color.gray));
            if(kilo.getText().toString().equals("12.5kg")) {
                kilo.setText("7kg");

            }else if (kilo.getText().toString().equals("7kg")){
                kilo.setText("5kg");
            }else if (kilo.getText().toString().equals("5kg")){
                kilo.setText("3kg");
            }else {
                kilo.setText("0");
                angleA.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public void cart() {
        Intent intent = new Intent(getApplicationContext(), CartActivity.class);
        startActivity(intent);
    }
}
