package com.fgomes.healthcareproject.ui.vaccine.creation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient
import java.time.LocalDate
import java.util.*

class VaccineCreationViewModel(val localMemory: LocalMemory, application: Application) :
    AndroidViewModel(
        application
    ) {

    fun addVaccine(title: String, date: LocalDate, doctor: Doctor, patient: Patient) {
        val vaccine = VaccineModel(
            id = UUID.randomUUID().toString(),
            title = title,
            date = date,
            doctor = doctor,
            patient = patient
        )
        localMemory.addVaccine(vaccine)

    }

}