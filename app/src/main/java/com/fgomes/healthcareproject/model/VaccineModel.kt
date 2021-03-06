package com.fgomes.healthcareproject.model

import com.fgomes.healthcareproject.model.user.Doctor
import com.fgomes.healthcareproject.model.user.Patient
import java.io.Serializable
import java.time.LocalDate

data class VaccineModel(
    override val id: String,
    override val title: String,
    override val date: LocalDate,
    override val doctor: Doctor? = null,
    override val patient: Patient? = null,
    override var finished: Boolean = false
) : BaseModel, Serializable
