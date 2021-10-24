package com.fgomes.healthcareproject.model.user

import java.io.Serializable

data class Patient(
    override val birthday: String?,
    override val cpf: String,
    override val email: String,
    override val name: String,
    override val password: String,
    override val sex: Sex?,
    override val telephone: String?,
    val history: List<Int> = listOf()
) : User(), Serializable
