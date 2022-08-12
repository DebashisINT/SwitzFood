package com.mioamorefsm.features.lead.api

import com.mioamorefsm.features.NewQuotation.api.GetQuotListRegRepository
import com.mioamorefsm.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}