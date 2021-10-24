package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory

class GetDoctorsNameListUseCase(private val repository: LocalMemory) {

    fun run(): Array<String> {
        return repository.doctors.map { it.name }.toTypedArray()
    }
}