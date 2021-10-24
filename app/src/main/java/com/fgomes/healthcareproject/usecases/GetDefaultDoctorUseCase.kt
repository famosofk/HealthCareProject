package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory

class GetDefaultDoctorUseCase(private val repository: LocalMemory) {

    fun run() = repository.doctors[0]
}