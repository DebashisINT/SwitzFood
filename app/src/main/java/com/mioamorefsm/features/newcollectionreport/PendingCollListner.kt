package com.mioamorefsm.features.newcollectionreport

import com.mioamorefsm.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}