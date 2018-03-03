package id.sch.smkn2soe.feature.member

import id.sch.smkn2soe.base.presenter.MvpView
import id.sch.smkn2soe.model.User

/**
 * Created by DODYDMW19 on 1/30/2018.
 */

interface MemberView : MvpView {

    fun showMembers(members: List<User>?)

    fun onFailed(message: String?)

}
