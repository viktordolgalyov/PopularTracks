package com.viktordolgalyov.populartracks.component.trending.view

import com.viktordolgalyov.populartracks.common.LoadingView
import com.viktordolgalyov.populartracks.common.arch.View
import com.viktordolgalyov.populartracks.component.trending.data.Track

interface TrendingView : View, LoadingView {
    /**
     * Shows error state
     */
    fun showError()

    /**
     * Adds trending tracks to the view
     * @param data - list of the data
     */
    fun addData(data: List<Track>)
}