package com.haqueit.mpos.currencycleancodemvvm.data.remote

import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.CoinDetailDto
import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getcoins():List<CoinDto>;

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailDto
}