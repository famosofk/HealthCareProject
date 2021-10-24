package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.model.ConsultationModel

class FinishConsultationUseCase(val repository: LocalMemory) {
    fun run(consultation: ConsultationModel, currentPosition: Int): ConsultationModel {
        consultation.finished = true
        return repository.finishConsultation(consultation, currentPosition)
    }
}