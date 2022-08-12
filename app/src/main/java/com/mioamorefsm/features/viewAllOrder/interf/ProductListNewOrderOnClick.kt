package com.mioamorefsm.features.viewAllOrder.interf

import com.mioamorefsm.app.domain.NewOrderGenderEntity
import com.mioamorefsm.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}