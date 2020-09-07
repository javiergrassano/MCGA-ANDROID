package com.example.tptiendamobile.networking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tptiendamobile.model.ApiResponseArtist
import com.example.tptiendamobile.model.ApiResponseProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val api: Api) {


    fun getProducts(): LiveData<ApiResponseProduct> {

        val liveData = MutableLiveData<ApiResponseProduct>()

        api.getProducts().enqueue(object : Callback<ApiResponseProduct> {
            override fun onResponse(call: Call<ApiResponseProduct>, response: Response<ApiResponseProduct>) {
                if (response.isSuccessful && response.body() != null) {
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<ApiResponseProduct>, t: Throwable) {
//               TODO()
            }

        })

        return liveData
    }

    fun getArtist(): LiveData<ApiResponseArtist> {

        val liveData = MutableLiveData<ApiResponseArtist>()

        api.getArtist().enqueue(object : Callback<ApiResponseArtist> {
            override fun onResponse(call: Call<ApiResponseArtist>, response: Response<ApiResponseArtist>) {
                if (response.isSuccessful && response.body() != null) {
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<ApiResponseArtist>, t: Throwable) {
//                TODO()
            }
        })

        return liveData
    }


}