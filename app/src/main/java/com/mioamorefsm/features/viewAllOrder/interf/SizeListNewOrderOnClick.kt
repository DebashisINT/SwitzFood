package com.mioamorefsm.features.viewAllOrder.interf

import com.mioamorefsm.app.domain.NewOrderProductEntity
import com.mioamorefsm.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}