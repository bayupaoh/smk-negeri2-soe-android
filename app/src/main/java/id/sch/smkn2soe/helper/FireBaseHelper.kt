package id.sch.smkn2soe.helper

import android.app.Activity
import android.content.Context
import android.os.Bundle

import com.google.firebase.analytics.FirebaseAnalytics

/**
 * Created by DODYDMW19 on 10/19/2017.
 */

class FireBaseHelper {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    fun initialize(context: Context?) {
        // Obtain the FirebaseAnalytics instance.
        if (context != null) {
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(context)
        }
    }

    fun sendScreen(screenName: String, act: Activity?) {
        if (act != null && mFirebaseAnalytics != null) {
            mFirebaseAnalytics!!.setCurrentScreen(act, screenName, null/* class override */)
        }
    }

    fun sendEvent(eventName: String, data: Bundle) {
        if (mFirebaseAnalytics != null) {
            mFirebaseAnalytics!!.logEvent(eventName, data)
        }
    }

    companion object {

        private var sHelper: FireBaseHelper? = null

        fun instance(): FireBaseHelper {
            if (sHelper == null) {
                sHelper = FireBaseHelper()
            }
            return sHelper as FireBaseHelper
        }
    }
}
