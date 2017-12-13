package com.viktordolgalyov.populartracks.component.trending.presentation

import com.viktordolgalyov.populartracks.common.arch.Presenter
import com.viktordolgalyov.populartracks.component.trending.data.Track
import com.viktordolgalyov.populartracks.component.trending.domain.TrendingInteractor
import com.viktordolgalyov.populartracks.component.trending.router.TrendingRouter
import com.viktordolgalyov.populartracks.component.trending.view.TrendingView

class TrendingPresenter(private val interactor: TrendingInteractor,
                        private val router: TrendingRouter) : Presenter<TrendingView>() {
    private val currentData = mutableListOf<Track>()

    override fun doOnStart() {
        super.doOnStart()
        view?.showProgress()
        interactor.execute({ onDataLoaded(it) }, { onDataLoadingError(it) })
    }

    override fun doOnPause() {
        super.doOnPause()
        interactor.cancel()
    }

    private fun onDataLoaded(data: List<Track>) {
        view?.hideProgress()
        currentData.addAll(data)
        view?.addData(data)
    }

    private fun onDataLoadingError(error: Throwable) {
        view?.hideProgress()
        view?.showError()
    }
}