package com.fgomes.healthcareproject.adapter

interface ClickListener {
    fun onClick(position: Int, isDelete: Boolean = false, isEdit: Boolean = false)
}
