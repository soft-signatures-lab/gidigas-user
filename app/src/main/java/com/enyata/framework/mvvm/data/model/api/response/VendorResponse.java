package com.enyata.framework.mvvm.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VendorResponse {

    @Expose
    @SerializedName("rows")
    private List<Vendor> data;
    @Expose
    @SerializedName("responseMessage")
    private String responseMsg;

    public List<Vendor> getData() {
        return data;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

}

