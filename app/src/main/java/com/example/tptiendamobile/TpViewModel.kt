package com.example.tptiendamobile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tptiendamobile.model.ApiResponseProduct
import com.example.tptiendamobile.networking.Repository

class TpViewModel(private val repository: Repository) : ViewModel() {

    private var tpApiResponse: LiveData<ApiResponseProduct>? = null
//    private var liveData: MutableLiveData<List<Evento>>? = null

//    fun getCompany(id: Int): LiveData<TpApiResponse> {
//        if (tpApiResponse?.value == null) {
//            tpApiResponse = repository.getCompany(id)
//        }
//        return tpApiResponse as TpLiveData
//    }

    fun getProducts(): LiveData<ApiResponseProduct>{
        if (tpApiResponse?.value == null) {
            tpApiResponse = repository.getProducts()
        }
        return tpApiResponse as LiveData<ApiResponseProduct>
    }

//    fun getEvents(empresa_id: Int): MutableLiveData<List<Evento>>? {
//        if (liveData?.value == null) {
//            liveData = repository.getEvent(empresa_id)
//        }
//        return liveData
//    }
//
//    fun sendOrder(pedido: Pedido) {
//        repository.sendOrder(pedido)
//    }

}