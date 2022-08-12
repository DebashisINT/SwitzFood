package com.mioamorefsm.features.location.shopRevisitStatus

import com.mioamorefsm.features.location.shopdurationapi.ShopDurationApi
import com.mioamorefsm.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}