package com.example.marvelapplication.di

import android.content.Context
import com.example.marvelapplication.BuildConfig
import com.example.marvelapplication.data.api.MarvelApi
import com.example.marvelapplication.data.database.CharacterDataBase
import com.example.marvelapplication.domain.repository.MarvelRepository
import com.example.marvelapplication.domain.usecase.CharacterUseCase
import com.example.marvelapplication.domain.usecase.GetCharactersListUseCase
import com.example.marvelapplication.presentation.detail.DetailViewModel
import com.example.marvelapplication.presentation.home.HomeViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    viewModel { HomeViewModel() }

    viewModel { DetailViewModel() }

}

val repositoryModule = module {
    factory { MarvelRepository() }
}

val useCase = module {
    factory { CharacterUseCase() }

    factory { GetCharactersListUseCase() }
}

val dataBase = module {
    single { provideDataBase(get()) }
}

val netModule = module {
    single {
        provideGson()
    }

    single {
        providesRetrofit(get(), get())
    }

    single {
        provideOkHttpClient()
    }

    single { provideMarvelApiServices(get()) }
}

fun provideGson(): Gson =
    GsonBuilder().create()

fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()


fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(60 * 1000.toLong(), TimeUnit.MILLISECONDS)
        .readTimeout(60 * 1000.toLong(), TimeUnit.MILLISECONDS)
        .build()

fun provideMarvelApiServices(retrofit: Retrofit): MarvelApi =
    retrofit.create(MarvelApi::class.java)

fun provideDataBase(context: Context): CharacterDataBase =
    CharacterDataBase.getDatabaseInstance(context)