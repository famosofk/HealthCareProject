package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.model.ConsultationModel

class GetConsultationPositionUseCase(private val repository: LocalMemory) {

    fun run(consultation: ConsultationModel): Int {
       return repository.getConsultationPosition(consultation)
    }
}