package com.example.logoquiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.logoquiz.R
import com.example.logoquiz.adapter.LogoAdapter
import com.example.logoquiz.data.Logos
import com.example.logoquiz.databinding.HomeFragmentBinding
import com.example.logoquiz.utils.onLogoSelectionListener
import com.example.logoquiz.viewmodel.LogoViewModel

class HomeFragment:Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var logoAdapter: LogoAdapter

    lateinit var viewModel: LogoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = HomeFragmentBinding.inflate(LayoutInflater.from(context))
        viewModel = ViewModelProvider(requireActivity()).get(LogoViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        observeLogoData()
        viewModel.loadLogosData()

    }

    private fun observeLogoData() {
        viewModel.logosList.observe(viewLifecycleOwner,{
            logoAdapter.setData(it)
        })
    }

    private fun setAdapter() {
        logoAdapter = LogoAdapter(object : onLogoSelectionListener{
            override fun onLogoSelect(logo: Logos) {
                startQuizFragment(logo)
            }
        })

        binding.logosRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            itemAnimator = null
            adapter = logoAdapter
        }
    }

    fun startQuizFragment(logos: Logos){
        var bundle: Bundle = Bundle()
        bundle.putParcelable("logos", logos)
        if (NavHostFragment.findNavController(this).currentDestination?.id == R.id.HomeFragment)
            NavHostFragment.findNavController(this).navigate(
                R.id.action_HomeFragment_to_QuizFragment,
                bundle
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}