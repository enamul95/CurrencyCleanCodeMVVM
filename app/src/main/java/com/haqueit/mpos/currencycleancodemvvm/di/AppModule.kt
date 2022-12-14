package com.haqueit.mpos.currencycleancodemvvm.di

import com.haqueit.mpos.currencycleancodemvvm.common.Constrants
import com.haqueit.mpos.currencycleancodemvvm.data.remote.CoinPaprikaApi
import com.haqueit.mpos.currencycleancodemvvm.data.repository.CoinRepositoryImpl
import com.haqueit.mpos.currencycleancodemvvm.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi():CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constrants.BASE_URL)
            //addConverterFactory for json show serialize & des
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi) : CoinRepository{
        return CoinRepositoryImpl(api)
    }
}