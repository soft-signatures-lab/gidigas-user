package com.enyata.framework.mvvm.ui.vendor;

public class VendorList {

    private  String logoImage;
    private String vendorName;
    private  String amountPerKg;
    private String vendorLocation;

    private int ratingImage;

    public VendorList(String mLogoImage,String mVendorName,String mAmountPerKg,String mVendorLocation,int mRatingImage){
        logoImage = mLogoImage;
        vendorName = mVendorName;
        amountPerKg = mAmountPerKg;
        vendorLocation = mVendorLocation;
        ratingImage = mRatingImage;

    }

    public  String getLogoImage(){return logoImage;}
    public void setLogoImage(String mLogoImage){logoImage = mLogoImage;}
    public String getVendorName(){return vendorName;}
    public void setVendorName(String mVendorName){vendorName = mVendorName;}
    public String getAmountPerKg(){return amountPerKg;}
    public  void setAmountPerKg(String mAmountPerKg){vendorLocation = mAmountPerKg;}
    public  String getVendorLocation(){return vendorLocation;}
    public  void setVendorLocation(String mVendorLocation){vendorLocation = mVendorLocation;}
    public int getRatingImage(){return ratingImage;}
    public void setRatingImage(int mRatingImage){ratingImage = mRatingImage;}





}
