package com.example.tptiendamobile.ui.home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tptiendamobile.R
import com.example.tptiendamobile.TpViewModel
import com.example.tptiendamobile.adapter.ProductAdapter
import com.example.tptiendamobile.model.Product
import com.example.tptiendamobile.ui.detail.ProductDetailActivity
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home), ProductListener {

    private lateinit var tpViewModel: TpViewModel

    override fun onClick(product: Product, view: View) {
        startActivity(Intent(context, ProductDetailActivity::class.java).apply {
            putExtras(Bundle().apply {
                putParcelable("product", product)
            })
        }, ActivityOptions.makeSceneTransitionAnimation(requireActivity(), view, "view").toBundle())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tpViewModel = activity?.run { ViewModelProviders.of(this).get(TpViewModel::class.java) }
                ?: throw Exception("Invalid Activity")

        observe()
        setListener()
    }

    private fun setListener() {
        swipeRefresh.setOnRefreshListener {
            observe()
            swipeRefresh.isRefreshing = false
        }
    }

    private fun observe() {
        tpViewModel.getProducts().observe(viewLifecycleOwner, Observer {
            render(it.data)
        })
    }

    private fun render(data: List<Product>) {
        rvProducts.layoutManager = GridLayoutManager(context, 2)
        rvProducts.adapter = ProductAdapter(data.shuffled(), this)
    }

}


