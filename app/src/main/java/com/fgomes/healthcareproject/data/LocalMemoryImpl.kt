package com.fgomes.healthcareproject.data

import com.fgomes.healthcareproject.data.model.BaseModel
import com.fgomes.healthcareproject.data.model.ConsultationModel
import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient
import com.fgomes.healthcareproject.enums.ScreenType
import com.fgomes.healthcareproject.enums.UserTypes

class LocalMemoryImpl : LocalMemory {

    override val doctors: MutableList<Doctor> = mutableListOf()
    override val patients: MutableList<Patient> = mutableListOf()

    override val consultationList: MutableList<BaseModel> = mutableListOf(
        ConsultationModel(
            id = "1",
            title = "João Pedro - Ortopedista",
            date = "25/11/2021",
            doctor = doctors[0],
            patient = patients[0]
        ),
        ConsultationModel(
            id = "2",
            title = "Karen - Cardiologista",
            date = "26/11/2021",
            doctor = doctors[0],
            patient = patients[0]
        ),
        ConsultationModel(
            id = "3",
            title = "Joana - Oftalmologista",
            date = "27/11/2021",
            doctor = doctors[1],
            patient = patients[0]
        ),
        ConsultationModel(
            id = "4",
            title = "Henderson - Endrocrino",
            date = "28/11/2021",
            doctor = doctors[1],
            patient = patients[1]
        ),
    )

    override val vaccineList: MutableList<BaseModel> = mutableListOf(
        VaccineModel(id = "1", title = "Varíola", date = "16/02/2022", doctor = null),
        VaccineModel(id = "2", title = "Pfizer dose 1", date = "16/02/2022", doctor = null),
        VaccineModel(id = "3", title = "Pfizer dose 2", date = "16/05/2022", doctor = null),
        VaccineModel(id = "4", title = "Sarampo", date = "20/06/2022", doctor = null),
    )


    override var userType = UserTypes.NOT_INITIALIZED

    override fun getMockList(type: ScreenType): MutableList<BaseModel> {
        return if (type == ScreenType.CONSULTATION) {
            consultationList
        } else {
            vaccineList
        }
    }

    override fun addVaccine(item: VaccineModel) {
        vaccineList.add(item)
    }

    override fun addConsultation(item: VaccineModel) {
        consultationList.add(item)
    }

}
