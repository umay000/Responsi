package com.example.responsi;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseList{

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private ArrayList<DataRS> data;

    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public void setData(ArrayList<DataRS> data){
        this.data = data;
    }

    public ArrayList<DataRS> getData(){
        return data;
    }

    @Override
    public String toString(){
        return
                "HospitalResponse{" +
                        "status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        "}";
    }
}