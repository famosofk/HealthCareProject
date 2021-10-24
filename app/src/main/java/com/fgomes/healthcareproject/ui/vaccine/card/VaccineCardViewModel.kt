package com.fgomes.healthcareproject.ui.vaccine.card


import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.adapter.list.ClickListener
import com.fgomes.healthcareproject.adapter.vaccine.VaccineAdapter
import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.model.VaccineModel
import com.fgomes.healthcareproject.data.model.user.Patient
import com.fgomes.healthcareproject.extensions.toStringDate

class VaccineCardViewModel(val localMemory: LocalMemory) : ViewModel() {

    lateinit var patient: Patient
    lateinit var patientVaccineList: List<VaccineModel>

    lateinit var adapter: VaccineAdapter

    fun initDefaultPatient(): Patient {
        return localMemory.patients[0]
    }

    fun initAdapter(listener: ClickListener) {
        adapter = VaccineAdapter(patientVaccineList, listener, localMemory.userType)
    }

    fun getDoctor() = localMemory.doctors[0]

    private fun getVaccineList() = localMemory.vaccineList

    fun initVaccineListByPatient() {
        val copy = mutableListOf<VaccineModel>()
        getVaccineList().forEach { copy.add(it as VaccineModel) }
        copy.removeIf { it.patient != patient }
        patientVaccineList = copy.sortedBy { it.date.toEpochDay() }
    }

    fun filterVaccineList(s: String){
        val list = patientVaccineList.filter {
            when {
                s.contains("/")  -> {
                    it.date.toStringDate().contains(s)
                }
                s.trim().lowercase() == "apl" -> {
                    it.finished
                }
                s.trim().lowercase() == "nao" -> {
                    !it.finished
                }
                s.isEmpty() -> {
                    true
                }
                else -> {
                    it.title.lowercase().contains(s.lowercase())
                }
            }
        }
        adapter.list = list.sortedBy { it.date.toEpochDay() }
        adapter.notifyDataSetChanged()
    }

    fun applyVaccine(position: Int) {
        patientVaccineList[position].finished = true
        adapter.notifyDataSetChanged()
        localMemory.applyVaccine(patientVaccineList[position])
    }

}