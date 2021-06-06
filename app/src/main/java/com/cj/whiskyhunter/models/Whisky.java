package com.cj.whiskyhunter.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Whisky {
    @SerializedName("name")
    private String nameWhisky;

    @SerializedName("slug")
    private String slugWhisky;

    public Whisky(String nameWhisky, String slugWhisky) {
        this.nameWhisky = nameWhisky;
        this.slugWhisky = slugWhisky;
    }

    public String getNameWhisky() {
        return nameWhisky;
    }

    public void setNameWhisky(String nameWhisky) {
        this.nameWhisky = nameWhisky;
    }

    public String getSlugWhisky() {
        return slugWhisky;
    }

    public void setSlugWhisky(String slugWhisky) {
        this.slugWhisky = slugWhisky;
    }
}
