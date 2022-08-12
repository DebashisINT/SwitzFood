package com.mioamorefsm.features.location.shopRevisitStatus

import com.mioamorefsm.base.BaseResponse
import com.mioamorefsm.features.location.model.ShopDurationRequest
import com.mioamorefsm.features.location.model.ShopRevisitStatusRequest
import io.reactivex.Observable

class ShopRevisitStatusRepository(val apiService : ShopRevisitStatusApi) {
    fun shopRevisitStatus(shopRevisitStatus: ShopRevisitStatusRequest?): Observable<BaseResponse> {
        return apiService.submShopRevisitStatus(shopRevisitStatus)
    }
}