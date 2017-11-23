package com.proj.greenspades.network

import com.proj.greenspades.Data
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by karan on 23/11/17.
 */
interface Service {
    companion object {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://35.154.241.44:5555/api/v1/greenspades/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
    @GET("data")
    fun getData():Observable<Data>

}