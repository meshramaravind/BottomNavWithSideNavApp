package com.arvind.bottomnavwithsidenav.viewmodel.notification

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel
@Inject constructor(application: Application) :
    AndroidViewModel(application) {


}