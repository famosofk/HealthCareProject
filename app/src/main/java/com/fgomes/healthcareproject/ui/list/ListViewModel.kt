package com.fgomes.healthcareproject.ui.list

import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.model.BaseModel
import com.fgomes.healthcareproject.enums.ScreenType
import com.fgomes.healthcareproject.usecases.GetItemListUseCase
import com.fgomes.healthcareproject.usecases.GetUserTypeUseCase

class ListViewModel(
    private val getItemList: GetItemListUseCase,
    private val getUserType: GetUserTypeUseCase
    ) : ViewModel() {

    fun getUserType() = getUserType.run()

    fun getItemList(type: ScreenType): MutableList<BaseModel> {
        return getItemList.run(type)
    }
}