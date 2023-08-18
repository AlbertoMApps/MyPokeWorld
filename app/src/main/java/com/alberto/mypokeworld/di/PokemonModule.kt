package com.alberto.mypokeworld.di

import android.util.Log
import com.alberto.mypokeworld.data.remote.api.PokeApi
import com.alberto.mypokeworld.data.remote.commons.Constants.POKE_API_BASE_URL
import com.alberto.mypokeworld.data.remote.repository.PokemonRepositoryImplementation
import com.alberto.mypokeworld.domain.PokemonRepositoryService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule {

    @Provides
    @Singleton
    fun providePokemonApi(
        client: OkHttpClient,
        gson: Gson
    ): PokeApi =
        Retrofit.Builder()
            .baseUrl(POKE_API_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(PokeApi::class.java)

    @Provides
    @Singleton
    fun getGson(): Gson =
        GsonBuilder()
            .serializeNulls()
            .setLenient()
            .create()

    @Provides
    @Singleton
    fun getOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS)

        return httpBuilder
            .protocols(mutableListOf(Protocol.HTTP_1_1))
            .build()
    }

    @Provides
    @Singleton
    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor { message -> Log.d("Logger", message) }
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun providePokemonRepositoryImplementation(
        api: PokeApi
    ): PokemonRepositoryService =
        PokemonRepositoryImplementation(
            api
        )

}