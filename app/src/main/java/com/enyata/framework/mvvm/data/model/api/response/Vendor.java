package com.enyata.framework.mvvm.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vendor {

    @Expose
    @SerializedName("vendor_id")
    private int id;

    @Expose
    @SerializedName("vendor_name")
    private String VendorName;

    @Expose
    @SerializedName("location")
    private String Location;

//    @Expose
//    @SerializedName("address")
//    private String Address;

    @Expose
    @SerializedName("amount_per_kg")
    private String AmountPerKg;

//    @Expose
//    @SerializedName("latitude")
//    private String Latitude;
//    @Expose
//    @SerializedName("longitude")
//    private String Longitude;

    @Expose
    @SerializedName("image_url")
    private String Logo;

    @Expose
    @SerializedName("average_rating")
    private int Rating;


    public int getId(){return id;}
    public String getVendorName(){return VendorName;}
    public String getLocation(){return Location;}
    //public String getAddress(){return Address;}
    public String getAmountPerKg(){return AmountPerKg;}
//    public String getLatitude(){return Latitude;}
//    public String getLongitude(){return Longitude;}
    public String getLogo(){return Logo;}
    public int getRating(){return Rating;}


}
