package com.fgomes.healthcareproject.model.user

data class Doctor(
    override val birthday: String? = null,
    override val cpf: String,
    val crm: String,
    override val email: String,
    override val name: String,
    override val password: String,
    override val sex: Sex? = null,
    override val telephone: String?,
) : User()
