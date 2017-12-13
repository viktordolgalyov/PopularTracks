package com.viktordolgalyov.populartracks.component.trending.view

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viktordolgalyov.populartracks.R
import com.viktordolgalyov.populartracks.component.trending.data.Track
import com.viktordolgalyov.populartracks.component.trending.presentation.TrendingPresenter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_trending.*
import javax.inject.Inject

class TrendingFragment : DaggerFragment(), TrendingView {
    @Inject lateinit var presenter: TrendingPresenter

    companion object {
        fun newInstance() = TrendingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_trending, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.bindView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unbindView()
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun showError() {
    }

    override fun addData(data: List<Track>) = (tracks.adapter as TrackAdapter).addData(data)

    private fun initViews() {
        tracks.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        tracks.adapter = TrackAdapter()
        tracks.itemAnimator = DefaultItemAnimator()
    }
}