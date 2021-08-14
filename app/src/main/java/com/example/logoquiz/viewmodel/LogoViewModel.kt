package com.example.logoquiz.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logoquiz.data.LogoRepository
import com.example.logoquiz.data.Logos
import kotlinx.coroutines.launch

class LogoViewModel:ViewModel() {


    var logoRepository: LogoRepository = LogoRepository()

    private val _logosList = MutableLiveData<List<Logos>>()
    val logosList: LiveData<List<Logos>> = _logosList

    fun loadLogosData() = viewModelScope.launch {
        _logosList.value = logoRepository.getLogosListFromJson()
    }
}