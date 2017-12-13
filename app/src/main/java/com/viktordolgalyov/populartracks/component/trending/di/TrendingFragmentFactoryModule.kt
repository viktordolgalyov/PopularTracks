package com.viktordolgalyov.populartracks.component.trending.di

import com.viktordolgalyov.populartracks.component.trending.view.TrendingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TrendingFragmentFactoryModule {

    @ContributesAndroidInjector(modules = arrayOf(TrendingModule::class))
    abstract fun trendingFragment(): TrendingFragment
}