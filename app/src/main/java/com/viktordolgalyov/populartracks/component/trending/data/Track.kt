package com.viktordolgalyov.populartracks.component.trending.data

data class Track(val id: String,
                 val artist: String,
                 val title: String,
                 val streamUrl: String,
                 val duration: Int,
                 val image: String)