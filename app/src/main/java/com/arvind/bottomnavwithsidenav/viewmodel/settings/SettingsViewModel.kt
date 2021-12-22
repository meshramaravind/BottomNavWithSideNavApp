package com.arvind.bottomnavwithsidenav.viewmodel.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {
}