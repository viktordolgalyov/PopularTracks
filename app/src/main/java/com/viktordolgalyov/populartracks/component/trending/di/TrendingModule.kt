package com.viktordolgalyov.populartracks.component.trending.di

import com.viktordolgalyov.populartracks.common.Workers
import com.viktordolgalyov.populartracks.common.di.ServerUrl
import com.viktordolgalyov.populartracks.common.provideApi
import com.viktordolgalyov.populartracks.component.trending.data.TrendingNetworkRepository
import com.viktordolgalyov.populartracks.component.trending.data.TrendingRepository
import com.viktordolgalyov.populartracks.component.trending.data.network.TrendingApi
import com.viktordolgalyov.populartracks.component.trending.domain.TrendingInteractor
import com.viktordolgalyov.populartracks.component.trending.presentation.TrendingPresenter
import com.viktordolgalyov.populartracks.component.trending.router.TrendingFragmentRouter
import com.viktordolgalyov.populartracks.component.trending.router.TrendingRouter
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class TrendingModule {

    @Provides
    fun api(@ServerUrl url: String, client: OkHttpClient): TrendingApi
            = provideApi(TrendingApi::class.java, url, client)

    @Provides
    fun repository(api: TrendingApi): TrendingRepository
            = TrendingNetworkRepository(api)

    @Provides
    fun interactor(repository: TrendingRepository,
                   workers: Workers) = TrendingInteractor(repository, workers)

    @Provides
    fun router(): TrendingRouter
            = TrendingFragmentRouter()

    @Provides
    fun presenter(interactor: TrendingInteractor,
                  router: TrendingRouter): TrendingPresenter
            = TrendingPresenter(interactor, router)
}