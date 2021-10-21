package com.fgomes.healthcareproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.databinding.MainFragmentBinding
import com.fgomes.healthcareproject.enums.UserTypes
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: MainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        enableClickListeners(binding)

        return binding.root
    }

    private fun enableClickListeners(binding: MainFragmentBinding) {
        binding.doctorButton.setOnClickListener {
            viewModel.defineUserType(UserTypes.DOCTOR)
            navigateToLoginScreen()
        }
        binding.nurseButton.setOnClickListener {
            viewModel.defineUserType(UserTypes.NURSE)
            navigateToLoginScreen()
        }
        binding.patientButton.setOnClickListener {
            viewModel.defineUserType(UserTypes.PATIENT)
            navigateToLoginScreen()
        }
    }

    private fun navigateToLoginScreen() =
        findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
}