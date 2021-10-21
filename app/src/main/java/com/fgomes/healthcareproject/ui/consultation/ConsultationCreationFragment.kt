package com.fgomes.healthcareproject.ui.consultation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fgomes.healthcareproject.R
import org.koin.android.ext.android.inject

class ConsultationCreationFragment : Fragment() {

    private val viewModel: ConsultationCreationViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.consultation_creation_fragment, container, false)
    }

}