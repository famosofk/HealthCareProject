package com.fgomes.healthcareproject.data.model

import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient
import java.io.Serializable
import java.time.LocalDate

data class ConsultationModel(
    override val id: String,
    override val title: String,
    override val date: LocalDate,
    override val doctor: Doctor? = null,
    override val patient: Patient? = null,
    override var finished: Boolean = false,
    val symptoms: MutableList<String> = mutableListOf()

) : Serializable, BaseModel {
    fun finishAppointment() {
        finished = true
    }

    fun addSymptoms(symptom: String) {
        symptoms.add(symptom)
    }
}