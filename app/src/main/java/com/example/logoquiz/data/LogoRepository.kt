package com.example.logoquiz.data

import android.content.Context
import com.example.logoquiz.application.LogoApplication
import com.example.logoquiz.utils.AppUtils
import com.google.gson.Gson
import kotlinx.coroutines.delay

class LogoRepository {

    suspend fun getLogosListFromJson():List<Logos>{
        val list = Gson().fromJson<List<Logos>>(AppUtils.getJsonDataFromAsset(LogoApplication.instance,"game.json"),Logos::class.java)
        delay(500)
        return list
    }
}