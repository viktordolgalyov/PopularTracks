package com.viktordolgalyov.populartracks.app

import android.app.Activity
import android.app.Application
import com.viktordolgalyov.populartracks.app.di.DaggerApplicationComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    private val component by lazy {
        DaggerApplicationComponent.builder()
                .app(this)
                .build()
    }
    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    override fun activityInjector() = injector
}