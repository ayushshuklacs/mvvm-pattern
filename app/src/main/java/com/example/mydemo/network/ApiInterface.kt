package com.example.mydemo.network

import com.example.mydemo.model.CoinModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @GET("coinlist")
    fun getCoinInfo(): Observable<CoinModel>


}