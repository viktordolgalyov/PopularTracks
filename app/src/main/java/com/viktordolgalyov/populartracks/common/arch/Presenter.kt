package com.viktordolgalyov.populartracks.common.arch

abstract class Presenter<V : View> {
    protected var view: V? = null

    /**
     * Binds view to the current presenter's instance
     * @param view - implementation of the view
     */
    fun bindView(view: V) {
        this.view = view
        doOnStart()
    }

    /**
     * Clears reference to the view
     */
    fun unbindView() {
        this.view = null
        doOnPause()
    }

    open fun doOnStart() {
        // default implementation does nothing
    }

    open fun doOnPause() {
        // default implementation does nothing
    }
}