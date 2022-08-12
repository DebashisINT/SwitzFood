package com.mioamorefsm.features.stockAddCurrentStock.api

import com.mioamorefsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.mioamorefsm.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}