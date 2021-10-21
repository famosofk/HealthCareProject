package com.fgomes.healthcareproject.di

import com.fgomes.healthcareproject.adapter.ClickListenerFactory
import com.fgomes.healthcareproject.adapter.ClickListenerFactoryImpl
import com.fgomes.healthcareproject.data.LocalMemory
import com.fgomes.healthcareproject.data.LocalMemoryImpl
import org.koin.dsl.module

val appModule = module {
    single { LocalMemoryImpl() as LocalMemory}
    single { ClickListenerFactoryImpl() as ClickListenerFactory}
}