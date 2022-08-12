package com.mioamorefsm.features.viewAllOrder.model

import com.mioamorefsm.app.domain.NewOrderColorEntity
import com.mioamorefsm.app.domain.NewOrderGenderEntity
import com.mioamorefsm.app.domain.NewOrderProductEntity
import com.mioamorefsm.app.domain.NewOrderSizeEntity
import com.mioamorefsm.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

