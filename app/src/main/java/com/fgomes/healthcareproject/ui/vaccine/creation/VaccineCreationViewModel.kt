package com.fgomes.healthcareproject.ui.vaccine.creation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fgomes.healthcareproject.model.user.Doctor
import com.fgomes.healthcareproject.model.user.Patient
import com.fgomes.healthcareproject.usecases.AddVaccineToPatientCardUseCase
import java.time.LocalDate

class VaccineCreationViewModel(
    private val addVaccineToPatientCard: AddVaccineToPatientCardUseCase,
    application: Application
) :
    AndroidViewModel(
        application
    ) {

    fun addVaccine(title: String, date: LocalDate, doctor: Doctor, patient: Patient) {
        addVaccineToPatientCard.run(title, date, doctor, patient)
    }

}