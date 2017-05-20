package me.oueslati.fakher.flickrerofitsample.dataprovider;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;


import me.oueslati.fakher.flickrerofitsample.model.Photo;
import me.oueslati.fakher.flickrerofitsample.model.SearchResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fakher Oueslati on 5/20/2017.
 */

public class Controller implements Callback<SearchResult> {
    static final String TAG = Controller.class.getSimpleName();
    static final String BASE_URL = "https://api.flickr.com/services/rest/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PhotoRetrofitService photoRetrofitService =
                retrofit.create(PhotoRetrofitService.class);

        Call<SearchResult> call = photoRetrofitService.getPhotos("TEST");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
        if (response.isSuccessful()) {
            Log.i(TAG, "onResponse successfull");
            SearchResult searchResult = response.body();
            List<Photo> photoList = searchResult.getPhotos().getPhoto();
            for (Photo p:photoList) {
                Log.i(TAG,p.getTitle());
            }
        } else {
            try {
                String error = response.errorBody().string();
                Log.e(TAG,error);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onFailure(Call<SearchResult> call, Throwable t) {
        t.printStackTrace();
    }


}


