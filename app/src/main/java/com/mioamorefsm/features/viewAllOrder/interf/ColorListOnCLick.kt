package com.mioamorefsm.features.viewAllOrder.interf

import com.mioamorefsm.app.domain.NewOrderGenderEntity
import com.mioamorefsm.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}