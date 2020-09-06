package com.example.tptiendamobile.ui.home

import android.view.View
import com.example.tptiendamobile.model.Product

interface ProductListener {

    fun onClick(product: Product, view: View)
}