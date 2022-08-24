package com.haqueit.mpos.currencycleancodemvvm.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haqueit.mpos.currencycleancodemvvm.common.Constrants
import com.haqueit.mpos.currencycleancodemvvm.common.Resource
import com.haqueit.mpos.currencycleancodemvvm.domain.use_case.get_coin.GetCoinUseCase
import com.haqueit.mpos.currencycleancodemvvm.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
   savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
       savedStateHandle.get<String>(Constrants.PARAM_COIN_ID)?.let { coinId ->
           getCoin(coinId)
       }
    }

    private fun getCoin(coinId:String) {
        getCoinUseCase(coinId).onEach { result ->
            {
                when (result) {
                    is Resource.Success ->{
                        _state.value = CoinDetailState(coin = result.data)

                    }
                    is Resource.Error ->{
                        _state.value = CoinDetailState(error = result.message ?: "An Unexpected Error Occured")

                    }
                    is Resource.Loading ->{
                        _state.value = CoinDetailState(isLoading = true)

                    }

                }
            }
        }.launchIn(viewModelScope)
    }

}
