package com.example.tptiendamobile.networking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

//    fun getEvent(id: Int): MutableLiveData<List<Evento>> {
//
//        val liveData = MutableLiveData<List<Evento>>()
//
//        api.getEvents(id).enqueue(object : Callback<List<Evento>> {
//
//            override fun onResponse(call: Call<List<Evento>>, response: Response<List<Evento>>) {
//                if (response.isSuccessful && response.body() != null) {
//                    liveData.value = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<List<Evento>>, t: Throwable) {
//
//            }
//
//        })
//
//        return liveData
//    }
//
//    fun sendOrder(pedido: Pedido) {
//
//        api.sendOrder(pedido).enqueue(object : Callback<Pedido> {
//
//            override fun onResponse(call: Call<Pedido>, response: Response<Pedido>) {
//                if (response.isSuccessful && response.body() != null) {
//
//                }
//
//            }
//
//            override fun onFailure(call: Call<Pedido>, t: Throwable) {
//
//            }
//        })
//    }
}