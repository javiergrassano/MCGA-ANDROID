package com.example.tptiendamobile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tptiendamobile.model.ApiResponseArtist
import com.example.tptiendamobile.model.ApiResponseProduct
import com.example.tptiendamobile.networking.Repository

class TpViewModel(private val repository: Repository) : ViewModel() {

    var tpApiResponseProduct: LiveData<ApiResponseProduct>? = null
    var tpApiResponseArtist: LiveData<ApiResponseArtist>? = null


    fun getProducts(): LiveData<ApiResponseProduct> {
        if (tpApiResponseProduct?.value == null) {
            tpApiResponseProduct = repository.getProducts()
        }
        return tpApiResponseProduct as LiveData<ApiResponseProduct>
    }

    fun getArtist(): LiveData<ApiResponseArtist> {
        if (tpApiResponseArtist?.value == null) {
            tpApiResponseArtist = repository.getArtist()
        }
        return tpApiResponseArtist as LiveData<ApiResponseArtist>

    }

    fun clearLiveData() {
        tpApiResponseProduct = MutableLiveData()
        tpApiResponseArtist = MutableLiveData()
    }

}