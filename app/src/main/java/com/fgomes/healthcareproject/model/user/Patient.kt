package com.fgomes.healthcareproject.model.user

import com.fgomes.healthcareproject.model.ConsultationModel
import java.io.Serializable

data class Patient(
    override val birthday: String?,
    override val cpf: String,
    override val email: String,
    override val name: String,
    override val password: String,
    override val sex: Sex?,
    override val telephone: String?,
    val history: MutableList<ConsultationModel> = mutableListOf()
) : User(), Serializable {
    fun addConsultationToHistory(consultationModel: ConsultationModel) {
        history.add(consultationModel)
    }
}
