package com.mioamorefsm.features.viewAllOrder.interf

import com.mioamorefsm.app.domain.NewOrderColorEntity
import com.mioamorefsm.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}