package com.enyata.framework.mvvm.ui.map;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityMapsBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;

public class MapsActivity extends BaseActivity<ActivityMapsBinding, MapViewModel> implements OnMapReadyCallback, MapNavigator {

    private GoogleMap mMap;
    @Inject
    ViewModelProviderFactory factory;
    ActivityMapsBinding activityMapsBinding;
    MapViewModel mapViewModel;

    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_maps;
    }

    @Override
    public MapViewModel getViewModel() {
        mapViewModel = ViewModelProviders.of(this, factory).get(MapViewModel.class);
        return mapViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMapsBinding = getViewDataBinding();
        mapViewModel.setNavigator(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng lagos = new LatLng(6, 3);
        mMap.addMarker(new MarkerOptions().position(lagos).title("Marker in Lagos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lagos));
    }

    @Override
    public void btnNext() {

    }
}
