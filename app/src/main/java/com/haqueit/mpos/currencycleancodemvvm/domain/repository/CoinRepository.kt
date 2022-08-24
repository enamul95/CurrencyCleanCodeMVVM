package com.haqueit.mpos.currencycleancodemvvm.domain.repository

import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.CoinDetailDto
import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto

}