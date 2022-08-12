package com.mioamorefsm.features.survey.api

import com.mioamorefsm.features.photoReg.api.GetUserListPhotoRegApi
import com.mioamorefsm.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}