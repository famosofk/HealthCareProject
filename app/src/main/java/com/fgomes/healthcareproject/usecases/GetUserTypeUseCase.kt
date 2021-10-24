package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.enums.UserTypes

class GetUserTypeUseCase(private val repository: LocalMemory) {

    fun run(): UserTypes {
        return repository.userType
    }

}