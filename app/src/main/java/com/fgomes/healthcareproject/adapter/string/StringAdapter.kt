package com.fgomes.healthcareproject.adapter.string

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fgomes.healthcareproject.databinding.StringAdapterLayoutBinding

class StringAdapter(val list: List<String>) : RecyclerView.Adapter<StringAdapter.ViewHolder>() {

    class ViewHolder(val binding: StringAdapterLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.placeholder.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StringAdapterLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}