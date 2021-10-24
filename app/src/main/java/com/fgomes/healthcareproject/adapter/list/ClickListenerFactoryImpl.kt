package com.fgomes.healthcareproject.adapter.list

import android.os.Bundle
import androidx.navigation.NavController
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.model.BaseModel
import com.fgomes.healthcareproject.model.ConsultationModel
import com.fgomes.healthcareproject.model.VaccineModel
import com.fgomes.healthcareproject.enums.ScreenType
import com.fgomes.healthcareproject.ui.vaccine.card.VaccineCardFragment

class ClickListenerFactoryImpl : ClickListenerFactory {

    override var list = mutableListOf<BaseModel>()
    override var currentOperation = ScreenType.NON_INITIALIZED
    override lateinit var currentAdapter: RecyclerListAdapter

    override fun createRecyclerClickListener(navController: NavController): ClickListener {
        return object : ClickListener {
            override fun onClick(position: Int, isDelete: Boolean, isEdit: Boolean) {
                if (currentOperation == ScreenType.NON_INITIALIZED) return

                when {
                    isDelete -> {
                        handleRemoveItem(position)
                    }
                    isEdit -> {
                        handleEditItem(position, navController)
                    }
                    else -> {
                        handleVisualizeItem(position, navController)
                    }
                }
            }
        }
    }

    private fun handleVisualizeItem(position: Int, navController: NavController) {
        val bundle = createBundle(position)
        navigateToVisualize(navController, bundle)

    }

    private fun navigateToVisualize(navController: NavController, bundle: Bundle) {
        navController.navigate(
            if (currentOperation == ScreenType.CONSULTATION) {
                R.id.action_listFragment_to_consultationVisualizationFragment
            } else {
                R.id.action_listFragment_to_vaccineCardFragment
            },
            bundle
        )
    }

    private fun createBundle(position: Int): Bundle {
        val bundle = Bundle()
        bundle.putSerializable(
            VaccineCardFragment.MODEL, if (currentOperation == ScreenType.CONSULTATION) {
                list[position] as ConsultationModel
            } else {
                list[position] as VaccineModel
            }
        )
        return bundle
    }

    private fun navigateToEdit(navController: NavController, bundle: Bundle) {
        navController.navigate(
            if (currentOperation == ScreenType.CONSULTATION) {
                R.id.action_listFragment_to_consultationCreationFragment
            } else {
                R.id.action_listFragment_to_vaccineCardFragment
            }, bundle
        )
    }

    private fun handleRemoveItem(position: Int) {
        list.removeAt(position)
        currentAdapter.notifyDataSetChanged()
    }

    private fun handleEditItem(
        position: Int,
        navController: NavController
    ) {
        val bundle = createBundle(position)
        bundle.putBoolean("edit", true)
        navigateToEdit(navController, bundle)
    }
}