package com.example.catsapp.Network

import com.example.catsapp.Model.CatFact
import retrofit2.Response
import retrofit2.http.GET

interface CatFactApiService {

    @GET("fact")
    suspend fun getRandomCatFact(): Response<CatFact>
}
