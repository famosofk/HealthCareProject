package com.fgomes.healthcareproject.data

import com.fgomes.healthcareproject.data.model.BaseModel
import com.fgomes.healthcareproject.enums.ScreenType
import com.fgomes.healthcareproject.enums.UserTypes

interface LocalMemory {
    var userType :UserTypes
    fun getMockList(type: ScreenType): MutableList<BaseModel>
    fun addOnList(type: ScreenType, item: BaseModel)
}