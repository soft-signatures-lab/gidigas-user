package com.enyata.framework.mvvm.ui.imageslide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.enyata.framework.mvvm.BR;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityImageSlideBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;

import javax.inject.Inject;

public class ImageSlideActivity extends BaseActivity<ActivityImageSlideBinding, ImageSlideViewModel> implements ImageSlideNavigator {
@Inject
    ViewModelProviderFactory  factory;
ActivityImageSlideBinding activityImageSlideBinding;
ImageSlideViewModel imageSlideViewModel;
    @Override
    public int getBindingVariable() {
        return com.enyata.framework.mvvm.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_image_slide;
    }

    @Override
    public ImageSlideViewModel getViewModel() {
        imageSlideViewModel = ViewModelProviders.of(this,factory).get(ImageSlideViewModel.class);
        return imageSlideViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityImageSlideBinding = getViewDataBinding();
    }
}
