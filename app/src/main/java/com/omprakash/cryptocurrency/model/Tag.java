package com.omprakash.cryptocurrency.model;

import com.google.gson.annotations.SerializedName;

public class Tag {
    private String id;
    private String name;
    @SerializedName("coin_counter")
    private Integer coinCounter;
    @SerializedName("ico_counter")
    private Integer icoCounter;
}
