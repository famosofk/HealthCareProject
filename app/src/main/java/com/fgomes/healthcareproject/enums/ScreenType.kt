package com.fgomes.healthcareproject.enums

enum class ScreenType(value: String) {
    NON_INITIALIZED("non initialized"),
    CONSULTATION("consultar"),
    VACCINE("vacinar");

    companion object {
        fun fromValue(argument: String): ScreenType =
            if (argument == "consultar") CONSULTATION else if (argument == "vacinar") VACCINE else NON_INITIALIZED

    }
}