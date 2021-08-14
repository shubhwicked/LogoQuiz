package com.example.logoquiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.logoquiz.databinding.QuizFragmentBinding
import com.example.logoquiz.viewmodel.LogoViewModel

class QuizFragment:Fragment() {

    private var _binding: QuizFragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: LogoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = QuizFragmentBinding.inflate(LayoutInflater.from(context))
        viewModel = ViewModelProvider(requireActivity()).get(LogoViewModel::class.java)
        return binding.root
    }
}