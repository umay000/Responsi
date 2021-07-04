package com.example.responsi;

import com.google.gson.annotations.SerializedName;

public class ResponseHome{

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private Data data;

    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public void setData(Data data){
        this.data = data;
    }

    public Data getData(){
        return data;
    }

    @Override
    public String toString(){
        return
                "CovidResponse{" +
                        "status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        "}";
    }
}
