package com.fgomes.healthcareproject.ui.hub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.databinding.FragmentHubBinding
import com.fgomes.healthcareproject.enums.UserTypes
import com.fgomes.healthcareproject.ui.list.ListFragment
import org.koin.android.ext.android.inject


class HubFragment : Fragment() {

    private val viewModel: HubViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentHubBinding = FragmentHubBinding.inflate(inflater, container, false)
        enableClickListeners(binding)

        return binding.root

    }

    private fun enableClickListeners(binding: FragmentHubBinding) {

        binding.appointmentButton.run {
            setOnClickListener {
                goToListScreen(text.toString())
            }
        }

        binding.vaccineButton.run {
            setOnClickListener {
                if (viewModel.getUserType() == UserTypes.PATIENT) {
                    goToVaccineCard()
                } else {
                    goToListScreen(text.toString())
                }
            }
        }
    }

    private fun goToVaccineCard() {
        findNavController().navigate(R.id.action_hubFragment_to_vaccineCardFragment)
    }

    fun goToListScreen(screenTitle: String) {
        val bundle = Bundle()
        bundle.putString(ListFragment.SCREEN_TITLE, screenTitle)
        findNavController().navigate(R.id.action_hubFragment_to_listFragment, bundle)
    }


}