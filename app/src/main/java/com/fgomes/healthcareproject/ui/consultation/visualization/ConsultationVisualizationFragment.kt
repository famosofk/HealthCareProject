package com.fgomes.healthcareproject.ui.consultation.visualization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fgomes.healthcareproject.R

class ConsultationVisualizationFragment : Fragment() {

    companion object {
        fun newInstance() = ConsultationVisualizationFragment()
    }

    private lateinit var viewModel: ConsultationVisualizationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.consultation_visualization_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConsultationVisualizationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}