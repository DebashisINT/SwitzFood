package com.mioamorefsm.features.chat.presentation

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.mioamorefsm.R
import com.mioamorefsm.app.NetworkConstant
import com.mioamorefsm.app.Pref
import com.mioamorefsm.app.SearchListener
import com.mioamorefsm.app.types.FragType
import com.mioamorefsm.app.utils.AppUtils
import com.mioamorefsm.base.BaseResponse
import com.mioamorefsm.base.presentation.BaseActivity
import com.mioamorefsm.base.presentation.BaseFragment
import com.mioamorefsm.features.chat.api.ChatRepoProvider
import com.mioamorefsm.features.chat.model.GroupUserDataModel
import com.mioamorefsm.features.chat.model.GroupUserResponseModel
import com.mioamorefsm.features.dashboard.presentation.DashboardActivity
import com.mioamorefsm.widgets.AppCustomTextView
import com.elvishew.xlog.XLog
import com.pnikosis.materialishprogress.ProgressWheel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddNewMsgFragment : BaseFragment() {

    private lateinit var mContext: Context

    private lateinit var progress_wheel: ProgressWheel
    private lateinit var tv_no_data: AppCustomTextView
    private lateinit var rv_user_list: RecyclerView
    private lateinit var rl_add_new_msg: RelativeLayout

    private var groupUserList: ArrayList<GroupUserDataModel>?= null
    private var grpUserAdapter: GroupUserListAdapter?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_add_new_msg, container, false)

        initView(view)
        getChatUserListApi()

        (mContext as DashboardActivity).setSearchListener(object : SearchListener {
            override fun onSearchQueryListener(query: String) {
                if (query.isBlank()) {
                    grpUserAdapter?.refreshList(groupUserList!!)
                } else {
                    grpUserAdapter?.filter?.filter(query)
                }
            }
        })

        return view
    }

    private fun initView(view: View) {
        view.apply {
            progress_wheel = findViewById(R.id.progress_wheel)
            tv_no_data = findViewById(R.id.tv_no_data)
            rv_user_list = findViewById(R.id.rv_user_list)
            rl_add_new_msg = findViewById(R.id.rl_add_new_msg)
        }
        progress_wheel.stopSpinning()
        rv_user_list.layoutManager = LinearLayoutManager(mContext)

        rl_add_new_msg.setOnClickListener(null)
    }

    private fun getChatUserListApi() {
        if (!AppUtils.isOnline(mContext)) {
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.no_internet))
            return
        }

        progress_wheel.spin()
        val repository = ChatRepoProvider.provideChatRepository()
        BaseActivity.compositeDisposable.add(
                repository.getGroupUserList()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            val response = result as GroupUserResponseModel
                            XLog.d("Get Group User List STATUS: " + response.status)
                            if (response.status == NetworkConstant.SUCCESS) {
                                progress_wheel.stopSpinning()
                                tv_no_data.visibility = View.GONE
                                groupUserList = response.group_user_list
                                setAdapter()
                            }
                            else {
                                progress_wheel.stopSpinning()
                                (mContext as DashboardActivity).showSnackMessage(response.message!!)
                            }

                        }, { error ->
                            error.printStackTrace()
                            progress_wheel.stopSpinning()
                            if (error != null)
                                XLog.d("Get Group User List ERROR: " + error.localizedMessage)
                            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                        })
        )
    }

    private fun setAdapter() {
        grpUserAdapter = GroupUserListAdapter(mContext, groupUserList) {
            (mContext as DashboardActivity).apply {
                newUserModel = it
                isRefreshChatUserList = true
                onBackPressed()
            }
        }
        rv_user_list.adapter = grpUserAdapter
    }
}