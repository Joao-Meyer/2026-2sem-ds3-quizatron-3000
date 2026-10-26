package com.aulasandroid.quizatron3000ds3t2sem2026.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SessionViewModel: ViewModel() {
    private var _userName = MutableLiveData<String>()
    var userName: LiveData<String> = _userName

    fun updateUserName( newValue: String ) {
        _userName.value = newValue
    }
}