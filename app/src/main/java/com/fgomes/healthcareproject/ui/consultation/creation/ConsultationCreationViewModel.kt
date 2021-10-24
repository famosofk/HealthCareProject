package com.fgomes.healthcareproject.ui.consultation.creation

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.fgomes.healthcareproject.model.user.Doctor
import com.fgomes.healthcareproject.model.user.Patient
import com.fgomes.healthcareproject.usecases.*
import java.lang.Exception
import java.time.LocalDate

class ConsultationCreationViewModel(
    private val getDoctorsNameList: GetDoctorsNameListUseCase,
    private val getPatientsNameList: GetPatientsNameListUseCase,
    private val getDoctorByName: GetDoctorByNameUseCase,
    private val getPatientByName: GetPatientByNameUseCase,
    private val saveConsultation: SaveConsultationUseCase,
    application: Application
) : AndroidViewModel(
    application
) {

    fun getDoctorListName(): Array<String> {
        return getDoctorsNameList.run()
    }

    fun getPatientsNameList(): Array<String> {
        return getPatientsNameList.run()
    }

    private fun getDoctorByName(name: String): Doctor? {
        return try {
            getDoctorByName.run(name)
        } catch (e: Exception) {
            throwException("Doctor not found")
            null
        }
    }

    private fun getPatientByName(name: String): Patient? {
        return try {
            getPatientByName.run(name)
        } catch (e: Exception) {
            throwException("Patient not found")
            null
        }
    }

    fun saveConsultation(title: String, date: LocalDate, doctor: String, patient: String): Boolean {
        return try {
            val doctorModel = getDoctorByName(doctor)!!
            val patientModel = getPatientByName(patient)!!
            saveConsultation.run(title, date, doctorModel, patientModel)
            true
        } catch (e: Exception) {
            false
        }
    }


    private fun throwException(message: String) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_LONG).show()
    }

}