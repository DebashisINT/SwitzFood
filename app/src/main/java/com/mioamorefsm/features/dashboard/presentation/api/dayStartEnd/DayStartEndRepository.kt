package com.mioamorefsm.features.dashboard.presentation.api.dayStartEnd

import com.mioamorefsm.app.Pref
import com.mioamorefsm.base.BaseResponse
import com.mioamorefsm.features.dashboard.presentation.model.DaystartDayendRequest
import com.mioamorefsm.features.dashboard.presentation.model.StatusDayStartEnd
import com.mioamorefsm.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.mioamorefsm.features.stockCompetetorStock.api.AddCompStockApi
import io.reactivex.Observable

class DayStartEndRepository (val apiService: DayStartEndApi){
    fun dayStart(daystartDayendRequest: DaystartDayendRequest): Observable<BaseResponse> {
        return apiService.submitDayStartEnd(daystartDayendRequest)
    }

    fun dayStartEndStatus(date:String): Observable<StatusDayStartEnd> {
        return apiService.statusDayStartEnd(Pref.session_token!!, Pref.user_id!!,date)
    }


}