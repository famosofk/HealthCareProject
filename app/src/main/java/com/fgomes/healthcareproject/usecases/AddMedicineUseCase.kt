package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.model.ConsultationModel

class AddMedicineUseCase(val repository: LocalMemory) {

    fun run(medicine: String, consultation: ConsultationModel, currentPosition: Int): ConsultationModel {
        consultation.medicines.add(medicine)
        return repository.addMedicine(consultation, currentPosition)
    }
}