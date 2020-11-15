package com.example.marvelapplication.di

import com.example.marvelapplication.data.api.MarvelApi
import com.example.marvelapplication.domain.repository.MarvelRepository
import com.example.marvelapplication.ui.detail.DetailViewModel
import com.example.marvelapplication.ui.home.HomeViewModel
import com.example.marvelapplication.utils.Consts
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(Consts.BASE_URL)
        .client(okHttpClient)
        .build()


fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(60 * 1000.toLong(), TimeUnit.MILLISECONDS)
        .readTimeout(60 * 1000.toLong(), TimeUnit.MILLISECONDS)
        .build()

fun provideMarvelApiServices(retrofit: Retrofit): MarvelApi =
    retrofit.create(MarvelApi::class.java)