package com.fgomes.healthcareproject.di

import com.fgomes.healthcareproject.usecases.*
import org.koin.dsl.module

val useCasesModule = module {
    single { SetUserTypeUseCase(get()) }
    single { GetUserTypeUseCase(get()) }
    single { GetItemListUseCase(get()) }
    single { GetDoctorsNameListUseCase(get()) }
    single { GetPatientsNameListUseCase(get()) }
    single { GetDoctorByNameUseCase(get()) }
    single { GetPatientByNameUseCase(get()) }
    single { SaveConsultationUseCase(get()) }
    single { ApplyVaccineUseCase(get()) }
    single { FilterVaccineListUseCase() }
    single { GetVaccineListByPatient() }
    single { GetVaccineListUseCase(get()) }
    single { GetDefaultPatientUseCase(get()) }
    single { GetDefaultDoctorUseCase(get()) }
    single { AddVaccineToPatientCardUseCase(get()) }
    single { AddMedicineUseCase(get()) }
    single { AddSymptomUseCase(get()) }
    single { FinishConsultationUseCase(get()) }
    single { GenerateAtestadoUseCase(get()) }
    single { GetConsultationPositionUseCase(get()) }
}