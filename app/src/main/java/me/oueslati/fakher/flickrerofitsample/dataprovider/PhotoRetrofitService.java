package me.oueslati.fakher.flickrerofitsample.dataprovider;

import java.util.List;

import me.oueslati.fakher.flickrerofitsample.model.SearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Fakher Oueslati on 5/17/2017.
 */

public interface PhotoRetrofitService {

    @GET("?method=flickr.photos.search&" +
            "api_key=04b28a9330eea3a2e5de056a4ad4dc59&" +
            "format=json&" +
            "nojsoncallback=1")
    Call<SearchResult> getPhotos(@Query("text") String text);

}
