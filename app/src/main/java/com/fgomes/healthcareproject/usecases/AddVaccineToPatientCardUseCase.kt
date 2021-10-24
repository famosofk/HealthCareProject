package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.model.VaccineModel
import com.fgomes.healthcareproject.model.user.Doctor
import com.fgomes.healthcareproject.model.user.Patient
import java.time.LocalDate
import java.util.*

class AddVaccineToPatientCardUseCase(private val repository: LocalMemory) {

    fun run(title: String, date: LocalDate, doctor: Doctor, patient: Patient) {
        val vaccine = VaccineModel(
            id = UUID.randomUUID().toString(),
            title = title,
            date = date,
            doctor = doctor,
            patient = patient
        )
        repository.addVaccine(vaccine)
    }
}