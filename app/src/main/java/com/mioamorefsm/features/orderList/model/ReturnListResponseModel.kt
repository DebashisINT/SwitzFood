package com.mioamorefsm.features.orderList.model

import com.mioamorefsm.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}