package com.enyata.framework.mvvm.ui.vendor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.data.model.api.response.LoginResponse;
import com.enyata.framework.mvvm.data.model.api.response.SignUpResponse;
import com.enyata.framework.mvvm.data.model.api.response.Vendor;
import com.enyata.framework.mvvm.data.model.api.response.VendorResponse;
import com.enyata.framework.mvvm.databinding.ActivityVendorBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.home.HomeActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class VendorActivity extends BaseActivity<ActivityVendorBinding, VendorViewModel> implements VendorNavigator {
    @Inject
    ViewModelProviderFactory factory;
    ActivityVendorBinding activityVendorBinding;
    VendorViewModel vendorViewModel;
    ListView listView;
    ImageView vendorImage;
    @Inject
    Gson gson;
    private ArrayList<VendorList> vendorList = new ArrayList<>();

    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_vendor;
    }

    @Override
    public VendorViewModel getViewModel() {
        vendorViewModel = ViewModelProviders.of(this, factory).get(VendorViewModel.class);
        return vendorViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityVendorBinding = getViewDataBinding();
        vendorViewModel.setNavigator(this);
        vendorViewModel.getVendor();

        listView = activityVendorBinding.vendorListView;
        vendorImage = activityVendorBinding.VendorArrow;
        vendorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getVendor(VendorResponse response) {

        List<Vendor> list = response.getData();
        for (int i = 0; i < list.size(); i++) {
            Vendor dataList = list.get(i);
            String url = dataList.getLogo();
            String name = dataList.getVendorName();
            String amount = dataList.getAmountPerKg();
            String address = dataList.getLocation();
            int rate = dataList.getRating();

            vendorList.add(new VendorList(url, name, amount, address, rate));
            VendorAdapter vendorAdapter = new VendorAdapter(VendorActivity.this, vendorList);
            listView.setAdapter(vendorAdapter);

        }


    }

    @Override
    public void handleError(Throwable throwable) {
        if (throwable != null) {
            ANError error = (ANError) throwable;

            VendorResponse response = gson.fromJson(error.getErrorBody(), VendorResponse.class);
            if (error.getErrorBody() != null) {
                Toast.makeText(getApplicationContext(), response.getResponseMsg(), Toast.LENGTH_SHORT).show();
                Log.d("hello", response.getResponseMsg());
            } else {
                Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_SHORT).show();

            }
            Log.d("error", "something went wrong");
        }
    }


}
