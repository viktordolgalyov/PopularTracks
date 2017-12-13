package com.viktordolgalyov.populartracks.common.arch

import io.reactivex.disposables.CompositeDisposable

abstract class Interactor {
    protected val disposables = CompositeDisposable()

    /**
     * Clears current subscriptions
     */
    fun cancel() = disposables.clear()
}