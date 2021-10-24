package com.fgomes.healthcareproject.model

import com.fgomes.healthcareproject.model.user.Doctor
import com.fgomes.healthcareproject.model.user.Patient
import java.time.LocalDate

interface BaseModel {
    val id: String
    val title: String
    val date: LocalDate
    val doctor: Doctor?
    val patient: Patient?
    var finished: Boolean
}