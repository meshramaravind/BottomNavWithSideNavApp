package com.arvind.bottomnavwithsidenav.view.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arvind.bottomnavwithsidenav.databinding.FragmentHelpBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragmentContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HelpFragment : BaseFragmentContent<FragmentHelpBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHelpBinding.inflate(inflater, container, false)
}