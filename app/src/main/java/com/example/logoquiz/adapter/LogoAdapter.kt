package com.example.logoquiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logoquiz.data.Logos
import com.example.logoquiz.databinding.LogosItemBinding
import com.example.logoquiz.utils.onLogoSelectionListener
import com.example.logoquiz.viewholder.LogoVH

class LogoAdapter(private val logoSelectionListener: onLogoSelectionListener) :
    RecyclerView.Adapter<LogoVH>() {

    private var logos = listOf<Logos>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LogoVH(LogosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            logoSelectionListener)


    override fun onBindViewHolder(holder: LogoVH, position: Int) {
        val logo = logos[position]
        holder.bind(logo)
    }

    override fun getItemCount() = logos.size

    fun setData(_logos : List<Logos>){
        this.logos = _logos
        notifyDataSetChanged()
    }
}