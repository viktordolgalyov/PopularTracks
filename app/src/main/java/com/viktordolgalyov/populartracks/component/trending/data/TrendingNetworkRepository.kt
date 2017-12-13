package com.viktordolgalyov.populartracks.component.trending.data

import com.viktordolgalyov.populartracks.component.trending.data.network.FanburstTrack
import com.viktordolgalyov.populartracks.component.trending.data.network.TrendingApi
import io.reactivex.Flowable
import io.reactivex.Single

class TrendingNetworkRepository(private val api: TrendingApi) : TrendingRepository {

    override fun getTrendingTracks(): Single<List<Track>> {
        return api.getTrendingTracks()
                .flatMapPublisher { Flowable.fromIterable(it) }
                .map { it.convert() }
                .toList()
    }
}

private fun FanburstTrack.convert(): Track {
    return Track(this.id,
            this.title.split("-").first().trim(),
            this.title.split("-").last().trim(),
            this.stream_url,
            this.duration,
            this.image_url)
}