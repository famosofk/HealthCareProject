package com.fgomes.healthcareproject.ui.list

import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.model.BaseModel
import com.fgomes.healthcareproject.enums.ScreenType

class ListViewModel(private val localMemory: LocalMemory) : ViewModel() {

    fun getUserType() =
        localMemory.userType

    fun getItemList(type: ScreenType): MutableList<BaseModel> {
        val list = localMemory.getMockList(type).sortedBy { it.date.toEpochDay() }.toMutableList()
        return list
    }
}