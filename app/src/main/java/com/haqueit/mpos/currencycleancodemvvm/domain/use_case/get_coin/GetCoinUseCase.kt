package com.haqueit.mpos.currencycleancodemvvm.domain.use_case.get_coin

import com.haqueit.mpos.currencycleancodemvvm.common.Resource
import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.toCoin
import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.toCoinDetail
import com.haqueit.mpos.currencycleancodemvvm.domain.model.Coin
import com.haqueit.mpos.currencycleancodemvvm.domain.model.CoinDetails
import com.haqueit.mpos.currencycleancodemvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    //Operator invoke fun use for called GetCoinUseCase class as a funciton
    // Flow use for multiple value like loading for progress bar, if sucess meet  of coin, error show error
    operator fun invoke(coinId:String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetails>(coin))

        }catch ( e: HttpException){
            emit(Resource.Error<CoinDetails>(e.localizedMessage?:"An Unexpected error occured"))

        }catch (e:IOException){
            emit(Resource.Error<CoinDetails>("Could't not reach server.Please check you internet"))

        }
    }



}