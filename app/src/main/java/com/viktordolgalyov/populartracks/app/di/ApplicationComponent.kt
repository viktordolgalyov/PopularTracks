package com.viktordolgalyov.populartracks.app.di

import android.content.Context
import com.viktordolgalyov.populartracks.app.App
import com.viktordolgalyov.populartracks.common.di.ServerUrl
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, AndroidInjectionModule::class, ActivityFactoryModule::class))
interface ApplicationComponent {
    fun inject(target: App)

    @ServerUrl
    fun serverUrl(): String

    @ApplicationContext
    fun context(): Context

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: App): Builder

        fun build(): ApplicationComponent
    }
}