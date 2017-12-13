package com.viktordolgalyov.populartracks.component.trending.data.network

import io.reactivex.Single
import retrofit2.http.GET

interface TrendingApi {
    /**
     * Returns the top 100 tracks on Fanburst.
     * This endpoint does not currently support pagination and returns all 100 tracks.
     */
    @GET("tracks/trending")
    fun getTrendingTracks(): Single<List<FanburstTrack>>
}