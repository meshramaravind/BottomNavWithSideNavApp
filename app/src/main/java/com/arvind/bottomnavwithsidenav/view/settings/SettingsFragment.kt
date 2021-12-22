package com.arvind.bottomnavwithsidenav.view.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.arvind.bottomnavwithsidenav.databinding.FragmentSettingsBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragment
import com.arvind.bottomnavwithsidenav.view.base.BaseFragmentContent
import com.arvind.bottomnavwithsidenav.viewmodel.settings.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding, SettingsViewModel>() {
    override val viewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSettingsBinding.inflate(inflater, container, false)
}