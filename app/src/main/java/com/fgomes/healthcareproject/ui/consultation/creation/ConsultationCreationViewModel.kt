package com.fgomes.healthcareproject.ui.consultation.creation

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.model.ConsultationModel
import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient
import java.lang.Exception
import java.time.LocalDate
import java.util.*

class ConsultationCreationViewModel(
    private val localMemory: LocalMemory,
    application: Application
) : AndroidViewModel(
    application
) {

    fun getDoctorListName(): Array<String> {
        return localMemory.doctors.map { it.name }.toTypedArray()
    }

    fun getPatientsNameList(): Array<String> {
        return localMemory.patients.map { it.name }.toTypedArray()
    }

    fun getDoctorByName(name: String): Doctor? {
        return try {
            localMemory.doctors.find {
                it.name.trim().lowercase().contains(name.trim().lowercase())
            }!!
        } catch (e: Exception) {
            throwException("Doctor not found")
            null
        }
    }

    fun getPatientByName(name: String): Patient? {
        return try {
            localMemory.patients.find {
                it.name.trim().lowercase().contains(name.trim().lowercase())
            }!!
        } catch (e: Exception) {
            throwException("Patient not found")
            null
        }
    }

    fun saveConsultation(title: String, date: LocalDate, doctor: String, patient: String) {
        val consultation = ConsultationModel(
            id = UUID.randomUUID().toString(),
            title = title,
            date = date,
            doctor = getDoctorByName(doctor),
            patient = getPatientByName(patient),
        )
        localMemory.addConsultation(consultation)

    }

    private fun throwException(message: String) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_LONG).show()
    }

}