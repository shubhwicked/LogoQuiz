package com.example.logoquiz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.logoquiz.R
import com.example.logoquiz.databinding.ActivityMainBinding
import com.example.logoquiz.viewmodel.LogoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LogoViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   // initialisation of viewbinding object
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.hide()
        viewModel = ViewModelProvider(this).get(LogoViewModel::class.java)
    }
}