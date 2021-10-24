package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.model.ConsultationModel

class AddSymptomUseCase(val repository: LocalMemory) {
    fun run(symptom: String, consultation: ConsultationModel, currentPosition: Int): ConsultationModel {
        consultation.symptoms.add(symptom)
        return repository.addSymptom(consultation, currentPosition)
    }
}