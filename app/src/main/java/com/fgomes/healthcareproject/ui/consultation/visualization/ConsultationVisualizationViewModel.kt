package com.fgomes.healthcareproject.ui.consultation.visualization

import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.model.ConsultationModel
import com.fgomes.healthcareproject.model.user.Doctor
import com.fgomes.healthcareproject.model.user.Patient
import com.fgomes.healthcareproject.usecases.*

class ConsultationVisualizationViewModel(
    private val getUserTypeUseCase: GetUserTypeUseCase,
    private val addSymptomUseCase: AddSymptomUseCase,
    private val addMedicineUseCase: AddMedicineUseCase,
    private val generateAtestadoUseCase: GenerateAtestadoUseCase,
    private val finishConsultationUseCase: FinishConsultationUseCase,
    private val getConsultationPosition: GetConsultationPositionUseCase
) :
    ViewModel() {
    lateinit var consultation: ConsultationModel
    lateinit var patient: Patient
    lateinit var doctor: Doctor
    var position: Int = -1

    fun initData(model: ConsultationModel) {
        consultation = model
        patient = model.patient!!
        doctor = model.doctor!!
    }

    fun getUserType() = getUserTypeUseCase.run()

    fun finishConsultation() {
        consultation = finishConsultationUseCase.run(consultation, getConsultationPosition.run(consultation))
    }

    fun addMedicine(value: String) {
        consultation = addMedicineUseCase.run(value, consultation, getConsultationPosition.run(consultation))
    }

    fun addSymptom(value: String) {
        consultation = addSymptomUseCase.run(value, consultation, getConsultationPosition.run(consultation))
    }

    fun addAtestado() {
        consultation = generateAtestadoUseCase.run(consultation, getConsultationPosition.run(consultation))
    }


}