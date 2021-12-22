package com.arvind.bottomnavwithsidenav.view.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.arvind.bottomnavwithsidenav.databinding.FragmentWelcomeBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragmentContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BaseFragmentContent<FragmentWelcomeBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initsview()
    }

    private fun initsview() = with(binding) {
        buttonSignInToContinueWelcome.setOnClickListener {
            val direction = WelcomeFragmentDirections.actionWelcomeFragmentToSignInFragment()
            it.findNavController().navigate(direction)
        }

        buttonJoinWithNewAccountWelcome.setOnClickListener {
            val direction = WelcomeFragmentDirections.actionWelcomeFragmentToSignUpFragment()
            it.findNavController().navigate(direction)
        }

    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentWelcomeBinding.inflate(inflater, container, false)
}