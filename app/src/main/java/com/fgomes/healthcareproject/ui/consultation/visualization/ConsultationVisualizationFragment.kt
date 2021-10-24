package com.fgomes.healthcareproject.ui.consultation.visualization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.adapter.AlertDialogFactory
import com.fgomes.healthcareproject.adapter.AlertDialogType
import com.fgomes.healthcareproject.adapter.string.StringAdapter
import com.fgomes.healthcareproject.databinding.ConsultationVisualizationFragmentBinding
import com.fgomes.healthcareproject.enums.UserTypes
import com.fgomes.healthcareproject.model.ConsultationModel
import com.fgomes.healthcareproject.ui.vaccine.card.VaccineCardFragment
import org.koin.android.ext.android.inject

class ConsultationVisualizationFragment : Fragment() {


    private val viewModel: ConsultationVisualizationViewModel by inject()
    private lateinit var binding: ConsultationVisualizationFragmentBinding
    private lateinit var symptomAdapter: StringAdapter
    private lateinit var medicineAdapter: StringAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConsultationVisualizationFragmentBinding.inflate(inflater, container, false)
        configUI()
        return binding.root
    }

    private fun configUI() {
        val consultation =
            requireArguments().getSerializable(VaccineCardFragment.MODEL) as ConsultationModel
        configToolbar(binding, consultation)
        configPatientData(binding, consultation)
        try {
            viewModel.initData(consultation)
        } catch (e: Exception) {
            toast("Invalid consultation")
        }
        initAdapters()
        showActionMenu()
        updateAtestadoState()
        initMenuButtons()
    }

    private fun initMenuButtons() {
        binding.addSymptom.setOnClickListener {
            AlertDialogFactory.displayAlertDialog(
                requireContext(),
                AlertDialogType.SYMPTOM,
                ::handleAddSymptom
            )
        }
        binding.addMedicine.setOnClickListener {
            AlertDialogFactory.displayAlertDialog(
                requireContext(),
                AlertDialogType.MEDICIME,
                ::handleAddMedicine
            )
        }

        binding.addAtestado.setOnClickListener {
            viewModel.addAtestado()
            updateAtestadoState()
        }

        binding.finishConsultation.setOnClickListener {
            viewModel.finishConsultation()
            showActionMenu()
        }
    }

    private fun handleAddSymptom(value: String) {
        viewModel.addSymptom(value)
        symptomAdapter.notifyDataSetChanged()
    }

    private fun handleAddMedicine(value: String) {
        viewModel.addMedicine(value)
        medicineAdapter.notifyDataSetChanged()
    }

    private fun initAdapters() {
        symptomAdapter = StringAdapter(viewModel.consultation.symptoms)
        medicineAdapter = StringAdapter(viewModel.consultation.medicines)

        binding.medicineRecyler.adapter = medicineAdapter
        binding.symptomsRecyler.adapter = symptomAdapter
    }

    private fun showActionMenu() {
        val shouldDisplayMenu = viewModel.getUserType() == UserTypes.DOCTOR
                && !viewModel.consultation.finished

        binding.menu.isVisible = shouldDisplayMenu
    }

    private fun updateAtestadoState() {
        if (viewModel.consultation.hasAtestado) {
            binding.atestadoValue.text = getString(R.string.generated_atestado)
        }
    }

    private fun toast(s: String) {
        Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show()
    }

    private fun configPatientData(
        binding: ConsultationVisualizationFragmentBinding,
        consultation: ConsultationModel
    ) {
        binding.patientNameConsultation.text = consultation.patient?.name
        binding.patientBirthdayConsultation.text = consultation.patient?.birthday
        binding.patientCPFconsultation.text = consultation.patient?.cpf
    }

    private fun configToolbar(
        binding: ConsultationVisualizationFragmentBinding,
        consultation: ConsultationModel
    ) {
        binding.consultationToolbar.title = consultation.doctor?.name
        binding.consultationToolbar.subtitle = consultation.doctor?.crm
    }

}