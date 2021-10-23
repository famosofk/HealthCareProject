package com.fgomes.healthcareproject.data.model.user

import java.io.Serializable

data class Nurse(
    override val birthday: String? = null,
    val coren: String,
    override val cpf: String,
    override val email: String,
    override val name: String,
    override val password: String,
    override val sex: Sex? = null,
    override val telephone: String?
) : User(), Serializable