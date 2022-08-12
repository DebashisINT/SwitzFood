package com.mioamorefsm.features.viewPPDDStock.model.stocklist

import com.mioamorefsm.base.BaseResponse

/**
 * Created by Saikat on 13-11-2018.
 */
class StockListResponseModel : BaseResponse() {
    var stock_list: ArrayList<StockListDataModel>? = null
}