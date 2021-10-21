package com.fgomes.healthcareproject.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fgomes.healthcareproject.R
import com.fgomes.healthcareproject.adapter.ClickListenerFactory
import com.fgomes.healthcareproject.adapter.ClickListenerFactoryImpl
import com.fgomes.healthcareproject.adapter.RecyclerListAdapter
import com.fgomes.healthcareproject.databinding.ListFragmentBinding
import com.fgomes.healthcareproject.enums.ScreenType
import com.fgomes.healthcareproject.enums.UserTypes
import org.koin.android.ext.android.inject

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by inject()
    private lateinit var type: ScreenType
    val clickListenerFactory: ClickListenerFactory by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ListFragmentBinding = ListFragmentBinding.inflate(inflater, container, false)
        arguments?.let { createUI(it, binding) }
        return binding.root
    }

    fun createUI(bundle: Bundle, binding: ListFragmentBinding) {
        val screenName = bundle.getString(SCREEN_TITLE)!!
        binding.toolbar.title = screenName
        type = ScreenType.fromValue(screenName.lowercase())
        clickListenerFactory.currentOperation = type
        if (viewModel.getUserType() == UserTypes.PATIENT) {
            binding.floatingActionButton.visibility = View.GONE
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(
                if (type == ScreenType.CONSULTATION) {
                    R.id.action_listFragment_to_consultationCreationFragment
                } else {
                    R.id.action_listFragment_to_vaccineCreationFragment
                }
            )

        }
        createAdapter(binding)
    }

    private fun createAdapter(binding: ListFragmentBinding) {
        val listener = clickListenerFactory.createRecyclerClickListener(findNavController())
        val currentList = viewModel.getItemList(type)
        clickListenerFactory.list = currentList
        val adapter = RecyclerListAdapter(
            type,
            listener,
            clickListenerFactory.list
        )

        clickListenerFactory.currentAdapter = adapter
        binding.recyclerView.adapter = adapter
    }

    companion object {
        const val SCREEN_TITLE = "screenTitle"
    }

}