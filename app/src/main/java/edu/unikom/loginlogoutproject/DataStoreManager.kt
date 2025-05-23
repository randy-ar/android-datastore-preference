package edu.unikom.loginlogoutproject

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name="user_preferences")

class DataStoreManager(private val context: Context) {

    private object PreferencesKeys {
        val NAMA = stringPreferencesKey("nama")
        val EMAIL = stringPreferencesKey("email")
        val PHONE = stringPreferencesKey("phone")
    }

    suspend fun saveUserData(nama: String, email: String, phone: String){
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.NAMA] = nama
            preferences[PreferencesKeys.EMAIL] = email
            preferences[PreferencesKeys.PHONE] = phone
        }
    }

    suspend fun clearUserData(){
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    val userDataFlow: Flow<UserData?> = context.dataStore.data.map { preferences ->
        val nama = preferences[PreferencesKeys.NAMA] ?: ""
        val email = preferences[PreferencesKeys.EMAIL] ?: ""
        val phone = preferences[PreferencesKeys.PHONE] ?: ""
        UserData(nama, email, phone)
    }
}