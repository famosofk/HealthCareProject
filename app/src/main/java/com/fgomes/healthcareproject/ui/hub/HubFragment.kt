package com.fgomes.healthcareproject.ui.hub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.findNavController
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.databinding.FragmentHubBinding
import com.fgomes.healthcareproject.ui.list.ListFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HubFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HubFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentHubBinding = FragmentHubBinding.inflate(inflater, container, false)
        enableClickListeners(binding)

        return binding.root

    }

    fun enableClickListeners(binding: FragmentHubBinding) {

        binding.appointmentButton.run {
            setOnClickListener {
                goToListScreen(text.toString())
            }
        }

        binding.vaccineButton.run {
            setOnClickListener {
                goToListScreen(text.toString())
            }
        }
    }

    fun goToListScreen(screenTitle: String) {
        val bundle = Bundle()
        bundle.putString(ListFragment.SCREEN_TITLE, screenTitle)
        findNavController().navigate(R.id.action_hubFragment_to_listFragment, bundle)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HubFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HubFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}