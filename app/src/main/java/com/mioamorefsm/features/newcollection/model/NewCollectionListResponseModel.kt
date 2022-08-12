package com.mioamorefsm.features.newcollection.model

import com.mioamorefsm.app.domain.CollectionDetailsEntity
import com.mioamorefsm.base.BaseResponse
import com.mioamorefsm.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}