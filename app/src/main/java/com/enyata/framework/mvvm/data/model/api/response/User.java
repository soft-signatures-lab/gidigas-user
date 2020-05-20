package com.enyata.framework.mvvm.data.model.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @Expose
    @SerializedName("surname")
    private String surname;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("phone")
    private String phone;

    @Expose
    @SerializedName("firstname")
    private String firstname;


    public String getSurname(){return surname;}
    public String getEmail(){return email;}
    public String getPhone(){return phone;}
    public String getFirstname(){return firstname;}
}
