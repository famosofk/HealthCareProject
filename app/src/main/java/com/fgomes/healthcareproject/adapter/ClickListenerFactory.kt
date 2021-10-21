package com.fgomes.healthcareproject.adapter

import androidx.navigation.NavController
import com.fgomes.healthcareproject.data.model.BaseModel
import com.fgomes.healthcareproject.enums.ScreenType

interface ClickListenerFactory {
    var list: MutableList<BaseModel>
    var currentOperation: ScreenType
    var currentAdapter: RecyclerListAdapter

    fun createRecyclerClickListener(navController: NavController): ClickListener

}