package com.enyata.framework.mvvm.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpResponse {

    @Expose
    @SerializedName("responseMessage")
    private String responseMsg;

    @Expose
    @SerializedName("token")
    private String token;

    @Expose
    @SerializedName("data")
    private User data;

   public String getResponseMsg(){return responseMsg;}
    public String getAccessToken(){return token;}
    public User getData(){return data;}
}
