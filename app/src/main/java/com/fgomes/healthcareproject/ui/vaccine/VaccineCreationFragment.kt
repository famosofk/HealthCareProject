package com.fgomes.healthcareproject.ui.vaccine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fgomes.healthcareproject.R
import org.koin.android.ext.android.inject

class VaccineCreationFragment : Fragment() {

    private val viewModel: VaccineCreationViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vaccine_creation_fragment, container, false)
    }

}