package br.senai.sp.jandira.retrofit_reqre

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val urlBase = "https://reqres.in/"

    fun getInstance(): Retrofit {




        return Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}