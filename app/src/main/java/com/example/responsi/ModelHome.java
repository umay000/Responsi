package com.example.responsi;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelHome extends ViewModel {
    private DataService apiMain;

    private MutableLiveData<ArrayList<ContentItem>> listMutableLiveData = new MutableLiveData<ArrayList<ContentItem>>();

    public void setListMutableLiveData(){
        if (this.apiMain == null){
            apiMain = new DataService();
        }

        apiMain.getApiCovid().getCovid().enqueue(new Callback<ResponseHome>() {
            @Override
            public void onResponse(Call<ResponseHome> call, Response<ResponseHome> response) {
                ResponseHome covidResponse = response.body();
                if (covidResponse != null && covidResponse.getData() != null){
                    ArrayList<ContentItem> contentItems = covidResponse.getData().getContent();
                    listMutableLiveData.postValue(contentItems);
                }
            }

            @Override
            public void onFailure(Call<ResponseHome> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<ArrayList<ContentItem>> getListMutableLiveData(){
        return listMutableLiveData;
    }
}

