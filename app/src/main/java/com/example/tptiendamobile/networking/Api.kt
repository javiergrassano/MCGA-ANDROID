package com.example.tptiendamobile.networking

import com.example.tptiendamobile.model.ApiResponseArtist
import com.example.tptiendamobile.model.ApiResponseProduct
import com.example.tptiendamobile.networking.ErrorHandlingAdapter.ErrorHandlingCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface Api {


    @GET("products?search=&artistId=&page=0&rows=0&order=1")
    fun getProducts(): Call<ApiResponseProduct>

    @GET("/api/artists?search=&page=0&rows=0&order=1")
    fun getArtist(): Call<ApiResponseArtist>

//    @GET("/api/empresas/{id}/")
//    fun getCompany(@Path("id") idEmpresa: Int): Call<Empresa>
//
//    @GET("/api/evento/")
//    fun getEvents(@Query("empresa_id") idEmpresa: Int): Call<List<Evento>>
//
//    @POST("/api/pedido/")
//    fun sendOrder(@Body pedido: Pedido): Call<Pedido>

    companion object {

        fun create(): Api {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(ErrorHandlingCallAdapterFactory())
                .baseUrl("http://uaicastelar.ddns.net:6681/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(Api::class.java)
        }
    }
}