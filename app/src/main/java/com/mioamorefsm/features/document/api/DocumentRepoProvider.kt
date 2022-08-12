package com.mioamorefsm.features.document.api

import com.mioamorefsm.features.dymanicSection.api.DynamicApi
import com.mioamorefsm.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}