package com.arvind.bottomnavwithsidenav.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.arvind.bottomnavwithsidenav.databinding.FragmentProfileBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragment
import com.arvind.bottomnavwithsidenav.viewmodel.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {

    override val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentProfileBinding.inflate(inflater, container, false)
}