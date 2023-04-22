package com.stark.storeapp.preferencehandler

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class PreferenceHandler @Inject constructor(
     val sharedPreferences: SharedPreferences
){
    var userToken: String
        get() = sharedPreferences.getString("token", "") ?: ""
        set(value) = sharedPreferences.edit { putString("token", value) }

    var userName: String
        get() = sharedPreferences.getString("userName", "") ?: ""
        set(value) = sharedPreferences.edit { putString("userName", value) }

    var name: String
        get() = sharedPreferences.getString("name", "") ?: ""
        set(value) = sharedPreferences.edit { putString("name", value) }

    var email: String
        get() = sharedPreferences.getString("email", "") ?: ""
        set(value) = sharedPreferences.edit { putString("email", value) }

    var userImage: String
        get() = sharedPreferences.getString("userImage", "") ?: ""
        set(value) = sharedPreferences.edit { putString("userImage", value) }

    fun clearSharedPreferences(){
        sharedPreferences.edit {
            clear()
            commit()
        }
    }
}