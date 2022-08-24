package com.haqueit.mpos.currencycleancodemvvm.presentation.coin_details

import com.haqueit.mpos.currencycleancodemvvm.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
}