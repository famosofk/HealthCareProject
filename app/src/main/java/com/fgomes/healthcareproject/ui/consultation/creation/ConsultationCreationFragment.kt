package com.fgomes.healthcareproject.ui.consultation.creation


import android.os.Build
import com.fgomes.healthcareproject.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fgomes.healthcareproject.databinding.ConsultationCreationFragmentBinding
import com.fgomes.healthcareproject.ui.list.ListFragment
import org.koin.android.ext.android.inject
import java.time.LocalDate


class ConsultationCreationFragment : Fragment() {

    private val viewModel: ConsultationCreationViewModel by inject()
    private var localDate: LocalDate = LocalDate.now()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ConsultationCreationFragmentBinding.inflate(inflater, container, false)
        configUI(binding)

        return binding.root
    }

    private fun configUI(binding: ConsultationCreationFragmentBinding) {
        prepareAutoCompleteSearchField(binding)
        binding.button.setOnClickListener { saveConsultation(binding) }
        binding.calendarView.setOnDateChangeListener { _, year, month, day ->
            val realMonth = month + 1
            val monthValue = if (month + 1 < 10) "0$realMonth" else realMonth.toString()
            val dayValue = if (day < 10) "0$day" else day.toString()
            localDate = LocalDate.parse("$year-$monthValue-$dayValue")
        }
    }

    private fun saveConsultation(binding: ConsultationCreationFragmentBinding) {
        val title = binding.consultationName.text.toString()
        if (title.isEmpty()) {
            toast("Adicione um título para a consulta.")
        } else if (hasFinishedProcess(title, binding)) {
            val bundle = Bundle()
            bundle.putString(ListFragment.SCREEN_TITLE, getString(R.string.consultation))
            findNavController().navigate(
                R.id.action_consultationCreationFragment_to_listFragment,
                bundle
            )
        }
    }

    private fun hasFinishedProcess(
        title: String,
        binding: ConsultationCreationFragmentBinding
    ): Boolean {
        return viewModel.saveConsultation(
            title = title,
            date = localDate,
            doctor = binding.selectDoctorField.text.toString(),
            patient = binding.selectPatientField.text.toString()
        )
    }

    private fun toast(s: String) {
        Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show()
    }

    private fun prepareAutoCompleteSearchField(binding: ConsultationCreationFragmentBinding) {
        val doctorsAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            viewModel.getDoctorListName()
        )
        val doctorsField = binding.selectDoctorField
        doctorsField.setAdapter(doctorsAdapter)

        val patientsAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            viewModel.getPatientsNameList()
        )
        val patientsField = binding.selectPatientField
        patientsField.setAdapter(patientsAdapter)
    }

}