package com.fgomes.healthcareproject.ui.main

import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.enums.UserTypes
import com.fgomes.healthcareproject.usecases.SetUserTypeUseCase

class MainViewModel(private val setUserType: SetUserTypeUseCase) : ViewModel() {
    fun defineUserType(currentType: UserTypes) {
        setUserType.run(currentType)
    }
}