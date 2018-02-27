package id.sch.smknn2soe.helper

import android.content.Context

/**
 * Created by DODYDMW19 on 7/26/2017.
 */

class PreferenceManager {

    var mApplicationContext: Context? = null

    var isLogin: Boolean
        get() {
            val preferences = mApplicationContext!!.getSharedPreferences(NAME, Context.MODE_PRIVATE)
            return preferences.getBoolean(KEY_IS_LOGIN, false)
        }
        set(isLogin) {
            val preferences = mApplicationContext!!.getSharedPreferences(NAME, Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putBoolean(KEY_IS_LOGIN, isLogin)
            editor.apply()
        }

    var isFirtInstall: Boolean
        get() {
            val preferences = mApplicationContext!!.getSharedPreferences(NAME, Context.MODE_PRIVATE)
            return preferences.getBoolean(KEY_IS_FIRSTINSTALL, true)
        }
        set(isFirstInstall) {
            val preferences = mApplicationContext!!.getSharedPreferences(NAME, Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putBoolean(KEY_IS_FIRSTINSTALL, isFirstInstall)
            editor.apply()
        }

    companion object {

        private var sManager: PreferenceManager? = null
        private val NAME = "id.sch.smknn2soe"
        private val KEY_IS_LOGIN = "login"
        private val KEY_IS_FIRSTINSTALL = "firstinstall"

        fun instance(): PreferenceManager {
            if (sManager == null) {
                sManager = PreferenceManager()
            }
            return sManager as PreferenceManager
        }
    }

}
