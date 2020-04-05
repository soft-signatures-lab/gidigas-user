package com.enyata.framework.mvvm.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityHomeBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivity;
import com.enyata.framework.mvvm.ui.map.MapsActivity;
import com.enyata.framework.mvvm.ui.order.OrderActivity;
import com.enyata.framework.mvvm.ui.support.SupportActivity;
import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> implements HomeNavigator, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    @Inject
    ViewModelProviderFactory factory;
    ActivityHomeBinding activityHomeBinding;
    HomeViewModel homeViewModel;
    DrawerLayout drawer;
    ImageView imageView;

    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        homeViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel.class);
        return homeViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = getViewDataBinding();
        homeViewModel.setNavigator(this);

        imageView = findViewById(R.id.navigationDrawerIcon);
        imageView.setOnClickListener(this);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setItemIconTintList(null);


    }


    @Override
    public void onhelp() {
        Intent intent = new Intent(getApplicationContext(), SupportActivity.class);
        startActivity(intent);
    }

    @Override
    public void onorder() {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_logout) {

            new AlertDialog.Builder(this,R.style.AlertDialogCustom)
                    .setTitle("Logout")
                    .setCancelable(false)
                    .setMessage("Would you like to logout?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    })
                    .setNegativeButton("No", (dialog, which) -> {

                    })
                    .show();


        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.navigationDrawerIcon:
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }
                break;
        }
    }
}