package com.fgomes.healthcareproject.di

import com.fgomes.healthcareproject.ui.consultation.ConsultationCreationViewModel
import com.fgomes.healthcareproject.ui.list.ListViewModel
import com.fgomes.healthcareproject.ui.main.MainViewModel
import com.fgomes.healthcareproject.ui.vaccine.VaccineCreationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { VaccineCreationViewModel() }
    viewModel { ConsultationCreationViewModel() }
    viewModel { ListViewModel(get()) }
}