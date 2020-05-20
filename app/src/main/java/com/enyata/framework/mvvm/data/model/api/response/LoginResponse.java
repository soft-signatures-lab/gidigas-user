package com.enyata.framework.mvvm.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("token")
    private String token;

    @Expose
    @SerializedName("data")
    private UserLogin loginData;

    @Expose
    @SerializedName("reponseMessage")
    private String reponseMsg;

    public String getAccessToken(){return token;}
    public String getMessage(){return message;}
    public UserLogin getLoginData(){return loginData;}
    public String getReponseMsg(){return reponseMsg;}
}
