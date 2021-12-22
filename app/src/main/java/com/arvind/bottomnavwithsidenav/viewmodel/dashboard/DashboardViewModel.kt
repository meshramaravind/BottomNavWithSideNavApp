package com.arvind.bottomnavwithsidenav.viewmodel.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

}