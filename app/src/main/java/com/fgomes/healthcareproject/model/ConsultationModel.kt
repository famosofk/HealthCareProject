package com.fgomes.healthcareproject.model

import com.fgomes.healthcareproject.model.user.Doctor
import com.fgomes.healthcareproject.model.user.Patient
import java.io.Serializable
import java.time.LocalDate

data class ConsultationModel(
    override val id: String,
    override val title: String,
    override val date: LocalDate,
    override val doctor: Doctor? = null,
    override val patient: Patient? = null,
    override var finished: Boolean = false,
    val symptoms: MutableList<String> = mutableListOf(),
    val medicines: MutableList<String> = mutableListOf(),
    var hasAtestado: Boolean = false
) : Serializable, BaseModel {

    fun addMedicine(value: String) {
        medicines.add(value)
    }

    fun finishAppointment() {
        finished = true
    }

    fun addSymptoms(symptom: String) {
        symptoms.add(symptom)
    }
}