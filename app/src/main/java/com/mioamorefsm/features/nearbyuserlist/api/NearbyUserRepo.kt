package com.mioamorefsm.features.nearbyuserlist.api

import com.mioamorefsm.app.Pref
import com.mioamorefsm.features.nearbyuserlist.model.NearbyUserResponseModel
import com.mioamorefsm.features.newcollection.model.NewCollectionListResponseModel
import com.mioamorefsm.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}