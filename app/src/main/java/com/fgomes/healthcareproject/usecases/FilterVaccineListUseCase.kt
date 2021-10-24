package com.fgomes.healthcareproject.usecases

import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.extensions.toNumberDate

class FilterVaccineListUseCase {
    fun run(s: String, list: List<VaccineModel>): List<VaccineModel> {
        return list.filter {
            when {
                s.contains("/") -> {
                    it.date.toNumberDate().contains(s)
                }
                s.trim().lowercase() == "apl" -> {
                    it.finished
                }
                s.trim().lowercase() == "nao" -> {
                    !it.finished
                }
                s.isEmpty() -> {
                    true
                }
                else -> {
                    it.title.lowercase().contains(s.lowercase())
                }
            }
        }.sortedBy { it.date.toEpochDay() }
    }
}