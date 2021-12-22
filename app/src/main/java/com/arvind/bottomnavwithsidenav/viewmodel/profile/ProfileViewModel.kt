package com.arvind.bottomnavwithsidenav.viewmodel.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

}