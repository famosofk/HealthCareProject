package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.model.user.Doctor

class GetDoctorByNameUseCase(private val repository: LocalMemory) {

    fun run(name: String): Doctor {
        return repository.doctors.find {
            it.name.trim().lowercase().contains(name.trim().lowercase())
        }!!
    }
}