package com.example.catsapp.Network


import com.example.catsapp.Model.CatFact
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatFactRepository {

    private val catFactApiService: CatFactApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        catFactApiService = retrofit.create(CatFactApiService::class.java)
    }

    suspend fun getRandomCatFact(): CatFact? {
        val response = catFactApiService.getRandomCatFact()
        return response.body() ?: throw RuntimeException("Failed to fetch cat fact")
    }
}

