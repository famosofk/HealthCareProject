package com.fgomes.healthcareproject.data.model

import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient
import java.io.Serializable

data class VaccineModel(
    override val id: String,
    override val title: String,
    override val date: String,
    override val doctor: Doctor? = null,
    override val patient: Patient? = null,
    override var finished: Boolean = false
) : BaseModel, Serializable {

}
