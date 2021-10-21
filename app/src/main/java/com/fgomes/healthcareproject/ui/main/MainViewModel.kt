package com.fgomes.healthcareproject.ui.main

import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.LocalMemoryImpl
import com.fgomes.healthcareproject.enums.UserTypes

class MainViewModel(val localMemory: LocalMemory) : ViewModel() {
    fun defineUserType(currentType: UserTypes) {
        localMemory.userType = currentType
    }
}