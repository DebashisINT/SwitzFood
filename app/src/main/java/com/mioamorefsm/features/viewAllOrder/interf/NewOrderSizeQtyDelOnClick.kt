package com.mioamorefsm.features.viewAllOrder.interf

import com.mioamorefsm.app.domain.NewOrderGenderEntity
import com.mioamorefsm.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}