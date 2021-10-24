package com.fgomes.healthcareproject.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun LocalDate.toStringDate(): String {
    return this.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
}
fun LocalDate.toNumberDate(): String {
    return this.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
}