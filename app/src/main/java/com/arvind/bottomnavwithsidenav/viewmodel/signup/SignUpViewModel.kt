package com.arvind.bottomnavwithsidenav.viewmodel.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

}