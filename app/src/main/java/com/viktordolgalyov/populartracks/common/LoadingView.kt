package com.viktordolgalyov.populartracks.common

interface LoadingView {
    /**
     * Shows progress indicator
     */
    fun showProgress()

    /**
     * Hides progress indicator
     */
    fun hideProgress()
}