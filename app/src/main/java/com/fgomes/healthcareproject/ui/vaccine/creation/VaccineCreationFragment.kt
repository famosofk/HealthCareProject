package com.fgomes.healthcareproject.ui.vaccine.creation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient
import com.fgomes.healthcareproject.databinding.VaccineCreationFragmentBinding
import com.fgomes.healthcareproject.ui.vaccine.card.VaccineCardFragment
import org.koin.android.ext.android.inject
import java.time.LocalDate
import java.util.*

class VaccineCreationFragment : Fragment() {

    private val viewModel: VaccineCreationViewModel by inject()
    private var localDate = LocalDate.now()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = VaccineCreationFragmentBinding.inflate(inflater, container, false)
        configUI(binding)
        return binding.root
    }

    private fun configUI(binding: VaccineCreationFragmentBinding) {
        val patient = requireArguments().getSerializable(PATIENT) as Patient
        binding.confirmButton.setOnClickListener {
            val title = binding.vaccineCreationTitle.text.toString()
            if (title.isEmpty()) {
                showEmptyNameVaccineAlert()
            } else {
                viewModel.addVaccine(
                    title,
                    localDate,
                    requireArguments().getSerializable(DOCTOR) as Doctor,
                    patient,
                )
                navigateBackToVaccineCard(patient)
            }
        }

        binding.calendarView2.setOnDateChangeListener { _, year, month, day ->
            val realMonth = month + 1
            val monthValue = if (month + 1 < 10) "0$realMonth" else realMonth.toString()
            val dayValue = if (day < 10) "0$day" else day.toString()
            localDate = LocalDate.parse("$year-$monthValue-$dayValue")
        }

    }

    private fun showEmptyNameVaccineAlert() {
        Toast.makeText(
            requireContext(),
            "Insira um título para a vacina",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun navigateBackToVaccineCard(patient: Patient) {
        val bundle = Bundle()
        bundle.putSerializable(
            VaccineCardFragment.MODEL, VaccineModel(
                id = UUID.randomUUID().toString(),
                title = patient.name,
                date = LocalDate.now(),
                patient = patient
            )
        )
        findNavController().navigate(
            R.id.action_vaccineCreationFragment_to_vaccineCardFragment,
            bundle
        )
    }

    companion object {
        const val DOCTOR = "doctor"
        const val PATIENT = "patient"
    }
}