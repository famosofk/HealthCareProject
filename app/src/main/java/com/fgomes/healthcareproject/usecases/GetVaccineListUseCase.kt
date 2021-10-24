package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory

class GetVaccineListUseCase(private val repository: LocalMemory) {
    fun run() = repository.vaccineList
}