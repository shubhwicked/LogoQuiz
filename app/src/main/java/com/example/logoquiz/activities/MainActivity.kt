package com.example.logoquiz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.logoquiz.R
import com.example.logoquiz.viewmodel.LogoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LogoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(LogoViewModel::class.java)
    }
}