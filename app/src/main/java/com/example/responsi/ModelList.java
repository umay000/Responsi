package com.example.responsi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.DataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelList extends ViewModel {
    private DataService apiMain;

    private MutableLiveData<ArrayList<DataRS>> listMutableLiveData = new MutableLiveData<ArrayList<DataRS>>();

    public void setListMutableLiveData(){
        if (this.apiMain == null){
            apiMain = new DataService();
        }

        apiMain.getApiCovid().getHospital().enqueue(new Callback<ResponseList>() {
            @Override
            public void onResponse(Call<ResponseList> call, Response<ResponseList> response) {
                ResponseList hospitalResponse = response.body();
                if (hospitalResponse != null && hospitalResponse.getData() != null){
                    ArrayList<DataRS> dataItems = hospitalResponse.getData();
                    listMutableLiveData.postValue(dataItems);
                }
            }

            @Override
            public void onFailure(Call<ResponseList> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<ArrayList<DataRS>> getListMutableLiveData(){
        return listMutableLiveData;
    }
}

