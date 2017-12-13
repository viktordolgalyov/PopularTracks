package com.viktordolgalyov.populartracks.component.trending.domain

import com.viktordolgalyov.populartracks.common.Workers
import com.viktordolgalyov.populartracks.common.arch.Interactor
import com.viktordolgalyov.populartracks.component.trending.data.Track
import com.viktordolgalyov.populartracks.component.trending.data.TrendingRepository

class TrendingInteractor(private val repository: TrendingRepository,
                         private val workers: Workers) : Interactor() {

    fun execute(onSuccess: (List<Track>) -> Unit, onError: (Throwable) -> Unit) {
        disposables.add(repository.getTrendingTracks()
                .subscribeOn(workers.subscribeWorker)
                .observeOn(workers.observeWorker)
                .subscribe(onSuccess, onError))
    }
}