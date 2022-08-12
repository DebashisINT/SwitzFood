package com.mioamorefsm.features.lead.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mioamorefsm.app.AppConstant
import com.mioamorefsm.app.domain.ProductRateEntity
import com.mioamorefsm.app.domain.ShopActivityEntity

@Dao
interface LeadActivityDao {

    @Insert
    fun insertAll(vararg obj: LeadActivityEntity)


    @Query("SELECT * FROM " + AppConstant.TBL_LEAD_ACTIVITY +" where activity_next_date=:activity_next_date")
    fun getAll(activity_next_date:String): List<LeadActivityEntity>

    @Query("update "+AppConstant.TBL_LEAD_ACTIVITY+" set activity_next_date=:activity_next_date where crm_id=:crm_id ")
    fun trash2(crm_id: String, activity_next_date: String)
}