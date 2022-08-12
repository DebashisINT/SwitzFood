package com.mioamorefsm.features.location.api

import com.mioamorefsm.app.Pref
import com.mioamorefsm.base.BaseResponse
import com.mioamorefsm.features.location.model.AppInfoInputModel
import com.mioamorefsm.features.location.model.AppInfoResponseModel
import com.mioamorefsm.features.location.model.ShopDurationRequest
import com.mioamorefsm.features.location.shopdurationapi.ShopDurationApi
import io.reactivex.Observable

/**
 * Created by Saikat on 17-Aug-20.
 */
class LocationRepo(val apiService: LocationApi) {
    fun appInfo(appInfo: AppInfoInputModel?): Observable<BaseResponse> {
        return apiService.submitAppInfo(appInfo)
    }

    fun getAppInfo(): Observable<AppInfoResponseModel> {
        return apiService.getAppInfo(Pref.session_token!!, Pref.user_id!!)
    }
}