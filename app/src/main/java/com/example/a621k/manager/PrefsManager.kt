package com.example.a621k.manager

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by Eldor Turgunov on 19.06.2022.
 * 6.2.1k
 * eldorturgunov777@gmail.com
 */
class PrefsManager private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences?

    companion object {
        private var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager? {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    }

    fun saveStringData(key: String?, value: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun saveLongData(key: String?, value: Long?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putLong(key, value!!)
        prefsEditor.apply()
    }

    fun saveIntData(key: String?, value: Int) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putInt(key, value)
        prefsEditor.apply()
    }

    fun saveFloatData(key: String?, value: Float) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putFloat(key, value)
        prefsEditor.apply()
    }

    fun saveBooleanData(key: String?, value: Boolean) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putBoolean(key, value)
        prefsEditor.apply()
    }

    fun clearAll() {
        val editor = sharedPreferences!!.edit()
        editor.clear()
        editor.apply()
    }
}