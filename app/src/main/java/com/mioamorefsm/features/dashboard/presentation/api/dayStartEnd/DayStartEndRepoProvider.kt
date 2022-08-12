package com.mioamorefsm.features.dashboard.presentation.api.dayStartEnd

import com.mioamorefsm.features.stockCompetetorStock.api.AddCompStockApi
import com.mioamorefsm.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}