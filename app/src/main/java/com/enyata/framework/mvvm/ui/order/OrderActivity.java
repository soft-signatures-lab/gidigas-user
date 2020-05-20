package com.enyata.framework.mvvm.ui.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityOrderBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.enyata.framework.mvvm.ui.mainActivity.MainLoginFragment;
import com.enyata.framework.mvvm.ui.mainActivity.MainRegisterFragment;
import com.enyata.framework.mvvm.ui.mainActivity.MainViewPagerAdapter;
import com.enyata.framework.mvvm.ui.support.SupportActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

public class OrderActivity extends BaseActivity<ActivityOrderBinding, OrderViewModel> implements OrderNavigator {
OrderAdapter orderAdapter;
TabLayout tabLayout;
ViewPager viewPager;
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

        orderAdapter = new OrderAdapter(getSupportFragmentManager());


        tabLayout = findViewById(R.id.tabLayout1);
        viewPager = findViewById(R.id.viewPager1);

        orderAdapter.addFragment(new OrderActiveFragment(), "Active");
        orderAdapter.addFragment(new OrderHistoryFragment(), "History");
        viewPager.setAdapter(orderAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for(int i=0; i < tabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(0, 0, 50, 0);
            tab.requestLayout();
        }

    }

    @Override
    public void backArrowOrder() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
