package com.fgomes.healthcareproject.adapter.vaccine

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.adapter.list.ClickListener
import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.databinding.VaccineItemBinding
import com.fgomes.healthcareproject.enums.UserTypes
import com.fgomes.healthcareproject.extensions.toStringDate

class VaccineAdapter(var list: List<VaccineModel>, val listener: ClickListener, val type: UserTypes) :
    RecyclerView.Adapter<VaccineAdapter.ViewHolder>() {

    class ViewHolder(val binding: VaccineItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: VaccineModel, position: Int, listener: ClickListener, type: UserTypes) {

            if (item.finished) {
                binding.applyVaccine.isVisible = false
                binding.linearLayout.setBackgroundColor(context.getColor(R.color.finishedAppointment))
            }
            if (type == UserTypes.PATIENT) {
                binding.applyVaccine.isVisible = false
            }

            binding.doctorName.text = item.doctor?.name ?: ""
            binding.vaccineDate.text = item.date.toStringDate()
            binding.vaccineTitle.text = item.title
            binding.applyVaccine.setOnClickListener { listener.onClick(position) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VaccineItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position, listener, type)
    }

    override fun getItemCount(): Int = list.size

}