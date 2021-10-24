package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.model.BaseModel
import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.data.model.user.Patient

class GetVaccineListByPatient {

    fun run(list: List<BaseModel>, patient: Patient): List<VaccineModel> {
        val copy = mutableListOf<VaccineModel>()
        list.forEach {
            if (it.patient == patient) {
                copy.add(it as VaccineModel)
            }
        }
        return copy.sortedBy { it.date.toEpochDay() }
    }
}