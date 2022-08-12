package com.mioamorefsm.features.addshop.model.assigntoddlist

import com.mioamorefsm.base.BaseResponse

/**
 * Created by Saikat on 03-10-2018.
 */
class AssignToDDListResponseModel : BaseResponse() {
    var assigned_to_dd_list: List<AssignToDDListDataModel>? = null
}