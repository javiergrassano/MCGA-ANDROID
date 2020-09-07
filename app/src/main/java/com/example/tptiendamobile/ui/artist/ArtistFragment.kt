package com.example.tptiendamobile.ui.artist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.tptiendamobile.R
import com.example.tptiendamobile.TpViewModel
import com.example.tptiendamobile.adapter.ArtistAdapter
import com.example.tptiendamobile.model.Artist
import kotlinx.android.synthetic.main.fragment_artist.*

class ArtistFragment : Fragment(R.layout.fragment_artist), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var tpViewModel: TpViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tpViewModel = activity?.run { ViewModelProviders.of(this).get(TpViewModel::class.java) }
                ?: throw Exception("Invalid Activity")

        observe()
        setListener()

    }

    private fun setListener() {
        swipeRefresh.setOnRefreshListener(this)
    }

    private fun observe() {
        tpViewModel.getArtist().observe(viewLifecycleOwner, Observer {
            render(it.data)
        })
    }

    private fun render(data: List<Artist>) {
        rvArtist.layoutManager = GridLayoutManager(context, 2)
        rvArtist.adapter = ArtistAdapter(data.shuffled())
    }

    override fun onRefresh() {
        observe()
        swipeRefresh.isRefreshing = false
    }

}