package com.arvind.bottomnavwithsidenav.viewmodel.otpverification

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OTPVerificationViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

}