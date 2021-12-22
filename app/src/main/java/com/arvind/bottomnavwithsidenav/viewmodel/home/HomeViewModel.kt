package com.arvind.bottomnavwithsidenav.viewmodel.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(application: Application) :
    AndroidViewModel(application) {

}