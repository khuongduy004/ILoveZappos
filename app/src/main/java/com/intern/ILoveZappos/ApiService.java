package com.intern.ILoveZappos;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by KD on 2/5/2017.
 */

interface ApiService {
    /*
     * Retrofit get annotation with our URL
     */
    @GET("/Search")//here is the other url part.best way is to start using /
    void getFeed(@Query("term") String search, @Query("key") String key, Callback<SearchModel> response);
}
