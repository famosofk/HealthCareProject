package com.fgomes.healthcareproject.data.model

import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient

interface BaseModel {
    val id: String
    val title: String
    val date: String
    val doctor: Doctor?
    val patient: Patient?
    var finished: Boolean
}