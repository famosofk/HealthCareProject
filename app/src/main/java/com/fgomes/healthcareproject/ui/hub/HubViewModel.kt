package com.fgomes.healthcareproject.ui.hub

import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.enums.UserTypes

class HubViewModel(val localMemory: LocalMemory) : ViewModel() {

    fun getUserType(): UserTypes {
        return localMemory.userType
    }

}
