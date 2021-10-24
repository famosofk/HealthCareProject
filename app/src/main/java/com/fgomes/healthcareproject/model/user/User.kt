package com.fgomes.healthcareproject.model.user

import java.io.Serializable



abstract class User: Serializable {
    open val birthday: String? = null
    abstract val cpf: String
    abstract val email: String
    abstract val name: String
    abstract val password: String
    open val sex: Sex? = null
    abstract val telephone: String?
}

enum class Sex : Serializable {
    FEMININE,
    MASCULINE
}