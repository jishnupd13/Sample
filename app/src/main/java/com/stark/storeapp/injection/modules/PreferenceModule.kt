package com.stark.storeapp.injection.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.stark.storeapp.preferencehandler.PreferenceHandler
import com.stark.storeapp.utils.SHARED_PREFERENCE_KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Singleton
    @Provides
    fun provideAppContext(@ApplicationContext context: Context) = context

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context) =
        context.getSharedPreferences(SHARED_PREFERENCE_KEY, AppCompatActivity.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSharedEditor(sharedPreferences: SharedPreferences) = sharedPreferences.edit()

    @Singleton
    @Provides
    fun providePreferenceHandler(sharedPreferences: SharedPreferences) =
        PreferenceHandler(sharedPreferences)
}