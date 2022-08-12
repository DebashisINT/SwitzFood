package com.mioamorefsm.features.location.shopdurationapi

import com.mioamorefsm.app.Pref
import com.mioamorefsm.app.utils.AppUtils
import com.mioamorefsm.base.BaseResponse
import com.mioamorefsm.features.location.model.MeetingDurationInputParams
import com.mioamorefsm.features.location.model.ShopDurationRequest
import com.mioamorefsm.features.location.model.VisitRemarksResponseModel
import com.elvishew.xlog.XLog
import io.reactivex.Observable

/**
 * Created by Pratishruti on 29-11-2017.
 */
class ShopDurationRepository(val apiService: ShopDurationApi) {
    fun shopDuration(shopDuration: ShopDurationRequest?): Observable<ShopDurationRequest> {
        XLog.d("ShopDurationRepository shop_visit_api_call"+AppUtils.getCurrentDateTime().toString()+"\ndata - "+shopDuration.toString())
        return apiService.submitShopDuration(shopDuration)
    }

    fun meetingDuration(meetingDuration: MeetingDurationInputParams?): Observable<BaseResponse> {
        return apiService.submitMeetingDuration(meetingDuration)
    }

    fun getRemarksList(): Observable<VisitRemarksResponseModel> {
        return apiService.getRemarksList(Pref.session_token!!, Pref.user_id!!)
    }
}