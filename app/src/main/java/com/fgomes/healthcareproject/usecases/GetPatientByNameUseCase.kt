package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.model.user.Patient

class GetPatientByNameUseCase(private val repository: LocalMemory) {

    fun run(name: String): Patient {
        return repository.patients.find {
            it.name.trim().lowercase().contains(name.trim().lowercase())
        }!!
    }
}