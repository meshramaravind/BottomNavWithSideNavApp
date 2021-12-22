package com.arvind.bottomnavwithsidenav.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.arvind.bottomnavwithsidenav.databinding.FragmentHomeBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragment
import com.arvind.bottomnavwithsidenav.viewmodel.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)


}