package com.fgomes.healthcareproject.ui.hub

import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.enums.UserTypes
import com.fgomes.healthcareproject.usecases.GetUserTypeUseCase

class HubViewModel(private val getUserType: GetUserTypeUseCase) : ViewModel() {

    fun getUserType(): UserTypes {
        return getUserType.run()
    }

}
