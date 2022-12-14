package com.haqueit.mpos.currencycleancodemvvm.domain.use_case.get_coins

import com.haqueit.mpos.currencycleancodemvvm.common.Resource
import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.toCoin
import com.haqueit.mpos.currencycleancodemvvm.domain.model.Coin
import com.haqueit.mpos.currencycleancodemvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCoinsUseCase @Inject constructor(
    //inject interface not interface implementation
    private val repository: CoinRepository
) {
    //Operator invoke fun use for called GetCoinUseCase class as a funciton
    // Flow use for multiple value like loading for progress bar, if sucess meet list of coin, error show error
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(Resource.Success<List<Coin>>(coins))

        }catch ( e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?:"An Unexpected error occured"))

        }catch (e:IOException){
            emit(Resource.Error<List<Coin>>("Could't not reach server.Please check you internet"))

        }
    }



}