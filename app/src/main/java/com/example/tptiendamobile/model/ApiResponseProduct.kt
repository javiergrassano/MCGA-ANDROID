package com.example.tptiendamobile.model

data class ApiResponseProduct(val recordPerPage: Int,
                              val totalPages: Int,
                              val data: List<Product>)