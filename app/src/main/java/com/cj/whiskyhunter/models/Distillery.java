package com.cj.whiskyhunter.models;

import com.google.gson.annotations.SerializedName;

public class Distillery {
    @SerializedName("name")
    private String nameDistillery;

    public Distillery(String nameDistillery) {
        this.nameDistillery = nameDistillery;
    }

    public String getNameDistillery() {
        return nameDistillery;
    }

    public void setNameDistillery(String nameDistillery) {
        this.nameDistillery = nameDistillery;
    }
}
