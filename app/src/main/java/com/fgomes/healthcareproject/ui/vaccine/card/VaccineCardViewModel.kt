package com.fgomes.healthcareproject.ui.vaccine.card


import androidx.lifecycle.ViewModel
import com.fgomes.healthcareproject.adapter.list.ClickListener
import com.fgomes.healthcareproject.adapter.vaccine.VaccineAdapter
import com.fgomes.healthcareproject.model.VaccineModel
import com.fgomes.healthcareproject.model.user.Patient
import com.fgomes.healthcareproject.usecases.*

class VaccineCardViewModel(
    private val applyVaccine: ApplyVaccineUseCase,
    private val filterVaccineList: FilterVaccineListUseCase,
    private val getVaccineListByPatient: GetVaccineListByPatient,
    private val getDefaultDoctor: GetDefaultDoctorUseCase,
    private val getDefaultPatient: GetDefaultPatientUseCase,
    private val getVaccineList: GetVaccineListUseCase,
    private val getUserType: GetUserTypeUseCase
) : ViewModel() {

    lateinit var patient: Patient
    lateinit var patientVaccineList: List<VaccineModel>

    lateinit var adapter: VaccineAdapter

    fun initDefaultPatient(): Patient {
        return getDefaultPatient.run()
    }

    fun initAdapter(listener: ClickListener) {
        adapter = VaccineAdapter(patientVaccineList, listener, getUserType.run())
    }

    fun getDoctor() = getDefaultDoctor.run()

    private fun getVaccineList() = getVaccineList.run()

    fun initVaccineListByPatient() {
        patientVaccineList = getVaccineListByPatient.run(getVaccineList(), patient)
    }

    fun filterVaccineList(s: String) {
        val list = filterVaccineList.run(s, patientVaccineList)
        adapter.list = list.sortedBy { it.date.toEpochDay() }
        adapter.notifyDataSetChanged()
    }

    fun applyVaccine(position: Int) {
        applyVaccine.run(patientVaccineList[position])
        adapter.notifyDataSetChanged()
    }

}