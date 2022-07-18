package com.example.mydemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydemo.databinding.ListDataBinding
import com.example.mydemo.model.CoinData

class CoinAdapter(private var list: MutableList<CoinData?>?) :
    RecyclerView.Adapter<CoinAdapter.ViewHolder>() {
    class ViewHolder(val binding: ListDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: CoinData) {
            coin.apply {

                binding.name.text = name
                Glide.with(itemView.context).load(pictures?.back?.url).into(binding.image);
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinAdapter.ViewHolder {
        return ViewHolder(
            ListDataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinAdapter.ViewHolder, position: Int) {
        holder.bind(list?.get(position)!!)
    }

    override fun getItemCount(): Int = list?.size ?: 0


}