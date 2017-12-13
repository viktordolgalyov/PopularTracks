package com.viktordolgalyov.populartracks.app.di

import com.viktordolgalyov.populartracks.app.App
import com.viktordolgalyov.populartracks.common.Workers
import com.viktordolgalyov.populartracks.common.di.ServerUrl
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun httpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor {
                    val url = it.request()
                            .url()
                            .newBuilder()
                            .addEncodedQueryParameter("client_id", "561aeb11-67de-40d2-8607-70bcbf557f81")
                            .build()
                    it.proceed(it.request().newBuilder().url(url).build())
                }
                .build()
        return client
    }

    @Provides
    @Singleton
    fun workers() = Workers(Schedulers.io(), AndroidSchedulers.mainThread())

    @Provides
    @Singleton
    @ApplicationContext
    fun context(app: App) = app.applicationContext

    @Provides
    @Singleton
    @ServerUrl
    fun serverUrl() = "https://api.fanburst.com/"
}