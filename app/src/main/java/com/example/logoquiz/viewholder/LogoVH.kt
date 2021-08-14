package com.example.logoquiz.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.logoquiz.data.Logos
import com.example.logoquiz.databinding.LogosItemBinding
import com.example.logoquiz.utils.onLogoSelectionListener

class LogoVH(
    private val binding: LogosItemBinding,
    private val logoSelectionListener: onLogoSelectionListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(logo: Logos) {
        binding.apply {
           Glide.with(binding.root.context).load(logo.imgUrl).into(this.logo)

            root.setOnClickListener { logoClicked(logo) }
        }
    }

    private fun logoClicked(logo: Logos) {
        logoSelectionListener.onLogoSelect(logo)
    }
}