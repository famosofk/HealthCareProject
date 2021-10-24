package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.enums.UserTypes

class SetUserTypeUseCase(val repository: LocalMemory) {

    fun run(user: UserTypes){
        repository.userType = user
    }
}