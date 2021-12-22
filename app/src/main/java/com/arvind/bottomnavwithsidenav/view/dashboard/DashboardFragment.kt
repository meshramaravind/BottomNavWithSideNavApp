package com.arvind.bottomnavwithsidenav.view.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.arvind.bottomnavwithsidenav.databinding.FragmentDashboardBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragment
import com.arvind.bottomnavwithsidenav.viewmodel.dashboard.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>() {
    override val viewModel: DashboardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDashboardBinding.inflate(inflater, container, false)
}