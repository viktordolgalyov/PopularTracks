package com.viktordolgalyov.populartracks.component.trending.data.network

data class FanburstTrack(val duration: Int = 0,
                         val private: Boolean = false,
                         val downloadable: Boolean = false,
                         val images: FanburstImage? = null,
                         val image_url: String = "",
                         val id: String = "",
                         val title: String = "",
                         val permalink: String = "",
                         val published_at: String = "",
                         val user: FanburstUser? = null,
                         val url: String = "",
                         val stream_url: String = "")