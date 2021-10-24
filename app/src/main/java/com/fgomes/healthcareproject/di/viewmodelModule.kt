package com.fgomes.healthcareproject.di

import com.fgomes.healthcareproject.ui.consultation.creation.ConsultationCreationViewModel
import com.fgomes.healthcareproject.ui.consultation.visualization.ConsultationVisualizationViewModel
import com.fgomes.healthcareproject.ui.hub.HubViewModel
import com.fgomes.healthcareproject.ui.list.ListViewModel
import com.fgomes.healthcareproject.ui.main.MainViewModel
import com.fgomes.healthcareproject.ui.vaccine.card.VaccineCardViewModel
import com.fgomes.healthcareproject.ui.vaccine.creation.VaccineCreationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { ConsultationCreationViewModel(get(), get(), get(), get(), get(), get()) }
    viewModel { ListViewModel(get(), get()) }
    viewModel { VaccineCardViewModel(get(), get(), get(), get(), get(), get(), get()) }
    viewModel { HubViewModel(get()) }
    viewModel { VaccineCreationViewModel(get(), get()) }
    viewModel { ConsultationVisualizationViewModel(get(), get(), get(), get(), get(), get()) }
}