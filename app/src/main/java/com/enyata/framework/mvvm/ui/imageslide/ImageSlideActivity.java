package com.enyata.framework.mvvm.ui.imageslide;


import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.enyata.framework.mvvm.R;
import com.enyata.framework.mvvm.ViewModelProviderFactory;
import com.enyata.framework.mvvm.databinding.ActivityImageSlideBinding;
import com.enyata.framework.mvvm.ui.base.BaseActivity;
import com.enyata.framework.mvvm.ui.mainActivity.MainActivity;

import javax.inject.Inject;

public class ImageSlideActivity extends BaseActivity<ActivityImageSlideBinding, ImageSlideViewModel> implements ImageSlideNavigator {
@Inject
    ViewModelProviderFactory  factory;
ActivityImageSlideBinding activityImageSlideBinding;
ImageSlideViewModel imageSlideViewModel;

    LinearLayout dotLayouts;
    ImageView[] dots;
    ImageAdapter imageAdapter;
    ViewPager viewPager;
    LinearLayout linearLayout;
    private int[] layouts = {R.layout.fragment_image_stress, R.layout.fragment_image_fast, R.layout.fragment_image_affordable,R.layout.fragment_image_customer};

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
        imageSlideViewModel.setNavigator(this);
        linearLayout = activityImageSlideBinding.getStarted;

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



        dotLayouts = findViewById(R.id.dotsLayout);
        viewPager = findViewById(R.id.viewpager);
        imageAdapter = new ImageAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(imageAdapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        createDots(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position == 3){
                    linearLayout.setVisibility(View.VISIBLE);
                }else {
                    linearLayout.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int current_position) {
        if (dotLayouts != null)
            dotLayouts.removeAllViews();
        dots = new ImageView[layouts.length];
        for (int i = 0; i < layouts.length; i++) {

            dots[i] = new ImageView(this);
            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active));

            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(6, 0, 6, 0);

            dotLayouts.addView(dots[i], params);
        }


    }



    @Override
    public void onskip() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
