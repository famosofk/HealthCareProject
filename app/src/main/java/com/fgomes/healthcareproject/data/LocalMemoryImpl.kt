package com.fgomes.healthcareproject.data

import com.fgomes.healthcareproject.data.model.BaseModel
import com.fgomes.healthcareproject.data.model.ConsultationModel
import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.data.model.user.Doctor
import com.fgomes.healthcareproject.data.model.user.Patient
import com.fgomes.healthcareproject.data.model.user.Sex
import com.fgomes.healthcareproject.enums.ScreenType
import com.fgomes.healthcareproject.enums.UserTypes
import java.time.LocalDate


class LocalMemoryImpl : LocalMemory {

    companion object {
        const val DEFAULT_TELEPHONE = "9xxxx-xxxx"
    }

    override val doctors: MutableList<Doctor> = mutableListOf(
        Doctor(
            birthday = "05/08/1980",
            cpf = "111.111.111-11",
            crm = "xxx-xx",
            email = "Ana.almeida@gmail.com",
            name = "Ana Almeida",
            password = "",
            sex = Sex.FEMININE,
            telephone = DEFAULT_TELEPHONE
        ),
        Doctor(
            birthday = "16/09/1991",
            cpf = "222.222.222-22",
            crm = "xxx-xx",
            email = "ana.maria.lopes@gmail.com",
            name = "Ana Maria Lopes",
            password = "",
            sex = Sex.FEMININE,
            telephone = DEFAULT_TELEPHONE
        ),
    )
    override val patients: MutableList<Patient> = mutableListOf(
        Patient(
            birthday = "15/12/2005",
            cpf = "333.333.333-33",
            email = "ana.julia@gmail.com",
            name = "Ana Júlia",
            password = "",
            sex = Sex.FEMININE,
            telephone = DEFAULT_TELEPHONE,
        ),
        Patient(
            birthday = "05/12/1950",
            cpf = "444.444.444-44",
            email = "osvaldo.cruz@gmail.com",
            name = "Osvaldo Cruz",
            password = "",
            sex = Sex.MASCULINE,
            telephone = DEFAULT_TELEPHONE,
        ),
    )

    override val consultationList: MutableList<BaseModel> = mutableListOf(
        ConsultationModel(
            id = "1",
            title = "João Pedro - Ortopedista",
            date = LocalDate.parse("2021-10-18"),
            doctor = doctors[0],
            patient = patients[0],
            finished = true
        ),
        ConsultationModel(
            id = "2",
            title = "Karen - Cardiologista",
            date = LocalDate.parse("2021-11-07"),
            doctor = doctors[0],
            patient = patients[0]
        ),
        ConsultationModel(
            id = "3",
            title = "Joana - Oftalmologista",
            date = LocalDate.parse("2021-12-15"),
            doctor = doctors[1],
            patient = patients[0]
        ),
        ConsultationModel(
            id = "4",
            title = "Henderson - Endrocrino",
            date = LocalDate.parse("2022-01-23"),
            doctor = doctors[1],
            patient = patients[1]
        ),
    )


    override val vaccineList: MutableList<BaseModel> = mutableListOf(
        VaccineModel(
            id = "1",
            title = "Varíola",
            date = LocalDate.parse("2021-10-30"),
            doctor = null
        ),
        VaccineModel(
            id = "2",
            title = "Pfizer dose 1",
            date = LocalDate.parse("2021-10-30"),
            doctor = null
        ),
        VaccineModel(
            id = "3",
            title = "Pfizer dose 2",
            date = LocalDate.parse("2022-05-10"),
            doctor = null
        ),
        VaccineModel(
            id = "4",
            title = "Sarampo",
            date = LocalDate.parse("2022-07-13"),
            doctor = null
        ),
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

    override fun addConsultation(item: ConsultationModel) {
        consultationList.add(item)
    }

}
