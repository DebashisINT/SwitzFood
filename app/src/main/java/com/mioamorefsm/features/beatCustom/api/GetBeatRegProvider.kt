package com.mioamorefsm.features.beatCustom.api



object GetBeatRegProvider {

    fun provideSaveButton(): GetBeatListRegRepository {
        return GetBeatListRegRepository(GetBeatProductListApi.create())
    }


}