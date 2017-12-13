package com.viktordolgalyov.populartracks.common

import io.reactivex.Scheduler

data class Workers(val subscribeWorker: Scheduler, val observeWorker: Scheduler)