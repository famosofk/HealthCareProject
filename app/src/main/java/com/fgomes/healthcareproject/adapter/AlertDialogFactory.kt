package com.fgomes.healthcareproject.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.fgomes.healthcareproject.databinding.AlertDialogLayoutBinding

object AlertDialogFactory {

    fun displayAlertDialog(
        context: Context,
        type: AlertDialogType,
        doOnSuccess: (value: String) -> Any
    ) {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val binding = AlertDialogLayoutBinding.inflate(inflater, null, false)
        builder.setView(binding.root)
        val dialog = builder.create()
        binding.apply {
            title.text = type.value
            submitButton.setOnClickListener {
                val value = binding.inputField.text.toString()
                if (value.isNotEmpty()) {
                    doOnSuccess(value)
                    dialog.dismiss()
                } else {
                    Toast.makeText(
                        context,
                        "Favor preencher o campo antes de submeter",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            cancelButton.setOnClickListener { dialog.dismiss() }
        }
        dialog.show()
    }


}

enum class AlertDialogType(val value: String) {
    MEDICIME("Adicionar medicamento"),
    SYMPTOM("Adicionar sintoma")

}