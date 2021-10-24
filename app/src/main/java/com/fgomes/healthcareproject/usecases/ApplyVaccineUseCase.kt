package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.model.VaccineModel

class ApplyVaccineUseCase(private val repository: LocalMemory) {

    fun run(vaccine: VaccineModel) {
        vaccine.finished = true
        repository.applyVaccine(vaccine)
    }
}