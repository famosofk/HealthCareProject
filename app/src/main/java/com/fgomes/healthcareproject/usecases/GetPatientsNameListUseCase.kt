package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory

class GetPatientsNameListUseCase(private val repository: LocalMemory) {

    fun run(): Array<String> {
        return repository.patients.map { it.name }.toTypedArray()
    }
}