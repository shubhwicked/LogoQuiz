package com.example.logoquiz.data

import android.content.Context
import com.example.logoquiz.application.LogoApplication
import com.example.logoquiz.utils.AppUtils
import com.google.gson.Gson
import kotlinx.coroutines.delay
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class LogoRepository {

    suspend fun getLogosListFromJson():List<Logos>{
        val listType: Type = object : TypeToken<List<Logos?>?>() {}.type
        val list = Gson().fromJson<List<Logos>>(AppUtils.getJsonDataFromAsset(LogoApplication.instance,"game.json"),listType)
        delay(500)
        return list
    }
}