package com.example.logoquiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.logoquiz.data.Logos
import com.example.logoquiz.databinding.QuizFragmentBinding
import com.example.logoquiz.viewmodel.LogoViewModel

class QuizFragment:Fragment() {

    private var _binding: QuizFragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: LogoViewModel
    lateinit var logo:Logos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments?.containsKey("logos") == true){
           logo = arguments?.getParcelable("logos")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = QuizFragmentBinding.inflate(LayoutInflater.from(context))
        viewModel = ViewModelProvider(requireActivity()).get(LogoViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLogoImage()
    }

    private fun setLogoImage() {
       Glide.with(this).load(logo.imgUrl).into(binding.logoImage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}