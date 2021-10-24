package com.fgomes.healthcareproject.ui.vaccine.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.adapter.list.ClickListener
import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.databinding.VaccineCardFragmentBinding
import com.fgomes.healthcareproject.ui.vaccine.creation.VaccineCreationFragment
import org.koin.android.ext.android.inject

class VaccineCardFragment : Fragment() {


    private val viewModel: VaccineCardViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = VaccineCardFragmentBinding.inflate(inflater, container, false)
        configUI(binding, arguments)
        return binding.root
    }

    private fun configUI(binding: VaccineCardFragmentBinding, arguments: Bundle?) {
        if (arguments != null) {
            val model = arguments.getSerializable(MODEL) as VaccineModel
            viewModel.patient = model.patient!!
        } else {
            viewModel.patient = viewModel.initDefaultPatient()
            binding.addVaccineButton.isVisible = false
        }
        viewModel.initVaccineListByPatient()
        updateToolbar(viewModel.patient.name, viewModel.patient.birthday!!, binding)
        viewModel.initAdapter(generateItemClickListener())
        binding.recyclerView.adapter = viewModel.adapter
        searchBarListener(binding)

        binding.addVaccineButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(VaccineCreationFragment.DOCTOR, viewModel.getDoctor())
            bundle.putSerializable(VaccineCreationFragment.PATIENT, viewModel.patient)
            findNavController().navigate(
                R.id.action_vaccineCardFragment_to_vaccineCreationFragment,
                bundle
            )
        }

    }

    private fun generateItemClickListener(): ClickListener {
        return object : ClickListener {
            override fun onClick(position: Int, isDelete: Boolean, isEdit: Boolean) {
                viewModel.applyVaccine(position)
            }
        }
    }

    private fun searchBarListener(binding: VaccineCardFragmentBinding) {
        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    viewModel.filterVaccineList(p0 ?: "")
                    return true
                }

            }
        )
    }

    private fun updateToolbar(
        title: String,
        subtitle: String,
        binding: VaccineCardFragmentBinding
    ) {
        binding.vaccineCardToolbar.title = title
        binding.vaccineCardToolbar.subtitle = subtitle
    }

    companion object {
        const val MODEL = "model"
    }
}