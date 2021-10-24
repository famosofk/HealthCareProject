package com.fgomes.healthcareproject.adapter.list

interface ClickListener {
    fun onClick(position: Int, isDelete: Boolean = false, isEdit: Boolean = false)
}
