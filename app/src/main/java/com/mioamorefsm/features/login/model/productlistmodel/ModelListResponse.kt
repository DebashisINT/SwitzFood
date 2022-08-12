package com.mioamorefsm.features.login.model.productlistmodel

import com.mioamorefsm.app.domain.ModelEntity
import com.mioamorefsm.app.domain.ProductListEntity
import com.mioamorefsm.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}