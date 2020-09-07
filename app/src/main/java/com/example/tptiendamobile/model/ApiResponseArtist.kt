package com.example.tptiendamobile.model

data class ApiResponseArtist(val recordPerPage: Int,
                             val totalPages: Int,
                             val data: List<Artist>)