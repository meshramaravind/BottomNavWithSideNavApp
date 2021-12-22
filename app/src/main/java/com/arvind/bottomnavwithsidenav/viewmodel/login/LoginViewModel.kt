package com.arvind.bottomnavwithsidenav.viewmodel.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

}