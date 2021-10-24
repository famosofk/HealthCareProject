package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.model.ConsultationModel
import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient
import java.time.LocalDate
import java.util.*

class SaveConsultationUseCase(private val repository: LocalMemory) {

    fun run(title: String, date: LocalDate, doctor: Doctor, patient: Patient) {
        val consultation = ConsultationModel(
            id = UUID.randomUUID().toString(),
            title = title,
            date = date,
            doctor = doctor,
            patient = patient,
        )
        repository.addConsultation(consultation)
    }
}