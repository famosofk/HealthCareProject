package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.model.BaseModel
import com.fgomes.healthcareproject.enums.ScreenType

class GetItemListUseCase(val repository: LocalMemory) {

    fun run(type: ScreenType): MutableList<BaseModel> {
        return repository.getMockList(type).sortedBy { it.date.toEpochDay() }.toMutableList()
    }
}