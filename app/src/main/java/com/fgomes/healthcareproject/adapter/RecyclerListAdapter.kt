package com.fgomes.healthcareproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fgomes.healthcareproject.data.model.BaseModel
import com.fgomes.healthcareproject.databinding.ListItemBinding
import com.fgomes.healthcareproject.enums.ScreenType


class RecyclerListAdapter(
    private val type: ScreenType,
    val listener: ClickListener,
    val list: MutableList<BaseModel>
) :
    RecyclerView.Adapter<RecyclerListAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ListItemBinding,
        private val type: ScreenType,
        private val listener: ClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BaseModel, position: Int) {
            initClickListeners(position)
            binding.listTitle.text = item.title
            binding.listDate.text = item.date

        }

        private fun initClickListeners(position: Int) {
            binding.listTitle.setOnClickListener {
                listener.onClick(position)
            }
            binding.deleteButton.setOnClickListener {
                listener.onClick(position, isDelete = true)
            }
            binding.editButton.setOnClickListener {
                listener.onClick(position, isEdit = true)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, type, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}

