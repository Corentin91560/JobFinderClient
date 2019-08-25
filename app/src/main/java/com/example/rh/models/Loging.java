package com.example.rh.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loging {
    @SerializedName("loginC")
    @Expose
    String loginC;
    @SerializedName("mdpC")
    @Expose
    String mdpC;

    public Loging(String loginC, String mdpC) {
        this.loginC = loginC;
        this.mdpC = mdpC;
    }

    public String getEmail() {
        return loginC;
    }

    public void setEmail(String loginC) {
        this.loginC = loginC;
    }

    public String getPassword() {
        return mdpC;
    }

    public void setPassword(String mdpC) {
        this.mdpC = mdpC;
    }
}
