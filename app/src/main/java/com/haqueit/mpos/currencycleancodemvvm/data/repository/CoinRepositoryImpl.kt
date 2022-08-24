package com.haqueit.mpos.currencycleancodemvvm.data.repository

import com.haqueit.mpos.currencycleancodemvvm.data.remote.CoinPaprikaApi
import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.CoinDetailDto
import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.CoinDto
import com.haqueit.mpos.currencycleancodemvvm.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
):CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
      return api.getcoins();
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
      return api.getCoinById(coinId)
    }
}