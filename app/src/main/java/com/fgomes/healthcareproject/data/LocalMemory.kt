package com.fgomes.healthcareproject.data

import com.fgomes.healthcareproject.model.BaseModel
import com.fgomes.healthcareproject.model.ConsultationModel
import com.fgomes.healthcareproject.model.VaccineModel
import com.fgomes.healthcareproject.model.user.Doctor
import com.fgomes.healthcareproject.model.user.Patient
import com.fgomes.healthcareproject.enums.ScreenType
import com.fgomes.healthcareproject.enums.UserTypes

interface LocalMemory {
    var userType: UserTypes
    val consultationList: MutableList<BaseModel>
    val vaccineList: MutableList<BaseModel>
    val doctors: MutableList<Doctor>
    val patients: MutableList<Patient>
    fun getMockList(type: ScreenType): MutableList<BaseModel>
    fun addVaccine(item: VaccineModel)
    fun addConsultation(item: ConsultationModel)
    fun applyVaccine(vaccineModel: VaccineModel)
}