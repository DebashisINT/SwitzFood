package com.mioamorefsm.features.viewAllOrder.interf

import com.mioamorefsm.features.viewAllOrder.model.ProductOrder

interface EmptyProductOnClick {
    fun emptyProductOnCLick(emptyFound:Boolean)
    fun delProductOnCLick(isDel:Boolean)
}