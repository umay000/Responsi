package com.example.responsi;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

    @SerializedName("metadata")
    private MetaData metadata;

    @SerializedName("content")
    private ArrayList<ContentItem> content;

    public void setMetadata(MetaData metadata){
        this.metadata = metadata;
    }

    public MetaData getMetadata(){
        return metadata;
    }

    public void setContent(ArrayList<ContentItem> content){
        this.content = content;
    }

    public ArrayList<ContentItem> getContent(){
        return content;
    }

    @Override
    public String toString(){
        return
                "Data{" +
                        "metadata = '" + metadata + '\'' +
                        ",content = '" + content + '\'' +
                        "}";
    }
}