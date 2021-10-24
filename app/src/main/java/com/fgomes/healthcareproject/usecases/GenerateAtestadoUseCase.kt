package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.model.ConsultationModel

class GenerateAtestadoUseCase(val repository: LocalMemory) {

    fun run(consultation: ConsultationModel, currentPosition: Int): ConsultationModel {
        consultation.hasAtestado = true
        return  repository.addAtestadoConsultation(consultation, currentPosition)
    }
}