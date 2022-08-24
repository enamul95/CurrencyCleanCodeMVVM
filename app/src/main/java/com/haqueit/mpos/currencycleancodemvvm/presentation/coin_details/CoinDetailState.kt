package com.haqueit.mpos.currencycleancodemvvm.presentation.coin_details

import com.haqueit.mpos.currencycleancodemvvm.domain.model.Coin
import com.haqueit.mpos.currencycleancodemvvm.domain.model.CoinDetails

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin : CoinDetails? = null,
    val error: String = ""
)
