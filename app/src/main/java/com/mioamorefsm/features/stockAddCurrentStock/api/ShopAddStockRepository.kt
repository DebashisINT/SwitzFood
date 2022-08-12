package com.mioamorefsm.features.stockAddCurrentStock.api

import com.mioamorefsm.base.BaseResponse
import com.mioamorefsm.features.location.model.ShopRevisitStatusRequest
import com.mioamorefsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.mioamorefsm.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.mioamorefsm.features.stockAddCurrentStock.model.CurrentStockGetData
import com.mioamorefsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}