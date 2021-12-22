package com.arvind.bottomnavwithsidenav.view.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.arvind.bottomnavwithsidenav.databinding.FragmentNotificationsBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragment
import com.arvind.bottomnavwithsidenav.viewmodel.notification.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, NotificationViewModel>() {
    override val viewModel: NotificationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNotificationsBinding.inflate(inflater, container, false)
}