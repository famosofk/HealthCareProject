package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory

class GetDefaultPatientUseCase(private val repository: LocalMemory) {

    fun run() = repository.patients[0]
}