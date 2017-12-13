package com.viktordolgalyov.populartracks.component.home

import android.os.Bundle
import com.viktordolgalyov.populartracks.R
import com.viktordolgalyov.populartracks.component.trending.view.TrendingFragment
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, TrendingFragment.newInstance(), TrendingFragment::class.java.simpleName)
                    .commit()
        }
    }
}