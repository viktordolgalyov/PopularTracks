package com.viktordolgalyov.populartracks.component.trending.data

import io.reactivex.Single

interface TrendingRepository {
    /**
     * Returns the top tracks
     * @return asynchronous list of tracks
     */
    fun getTrendingTracks(): Single<List<Track>>
}