package com.mioamorefsm.features.activities.api

import com.mioamorefsm.features.member.api.TeamApi
import com.mioamorefsm.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}