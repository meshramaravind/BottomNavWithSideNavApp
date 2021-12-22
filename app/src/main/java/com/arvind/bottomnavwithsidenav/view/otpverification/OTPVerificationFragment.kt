package com.arvind.bottomnavwithsidenav.view.otpverification

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.arvind.bottomnavwithsidenav.R
import com.arvind.bottomnavwithsidenav.databinding.FragmentOtpVerificationBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragment
import com.arvind.bottomnavwithsidenav.viewmodel.otpverification.OTPVerificationViewModel
import com.arvind.demoappbottom.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_otp_verification.view.*
import kotlinx.android.synthetic.main.fragment_otp_verification.*

@AndroidEntryPoint
class OTPVerificationFragment :
    BaseFragment<FragmentOtpVerificationBinding, OTPVerificationViewModel>() {

    override val viewModel: OTPVerificationViewModel by viewModels()
    lateinit var stringSMSOtpOne: String
    lateinit var stringSMSOtpTwo: String
    lateinit var stringSMSOtpThree: String
    lateinit var stringSMSOtpFour: String

    lateinit var stringSmsOTP: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initsView()
    }

    private fun initsView() = with(binding) {
        getOtpVerificationTextWatcher()
        buttonVerifyOtpVerification.setOnClickListener {
            hideKeyboard()
            stringSMSOtpOne =
                otpVerificationLayout.edOtp1Verification.text.toString().trim()
            stringSMSOtpTwo =
                otpVerificationLayout.edOtp2Verification.text.toString().trim()
            stringSMSOtpThree =
                otpVerificationLayout.edOtp3Verification.text.toString().trim()
            stringSMSOtpFour =
                otpVerificationLayout.edOtp4Verification.text.toString().trim()

            stringSmsOTP = stringSMSOtpOne.plus(stringSMSOtpTwo).plus(stringSMSOtpThree)
                .plus(stringSMSOtpFour)

            getOtpVerification()
        }
    }

    private fun getOtpVerificationTextWatcher() {
        otpVerificationLayout.ed_otp1_verification.addTextChangedListener(
            otpTextWatcherOne
        )
        otpVerificationLayout.ed_otp2_verification.addTextChangedListener(
            otpTextWatcherTwo
        )
        otpVerificationLayout.ed_otp3_verification.addTextChangedListener(
            otpTextWatcherThree
        )
        otpVerificationLayout.ed_otp4_verification.addTextChangedListener(
            otpTextWatcherFour
        )
    }

    private val otpTextWatcherOne: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (otpVerificationLayout.ed_otp1_verification.text.toString().length == 1) {
                otpVerificationLayout.ed_otp2_verification.requestFocus()
            }
        }

        override fun afterTextChanged(s: Editable) {

        }
    }

    private val otpTextWatcherTwo: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (otpVerificationLayout.ed_otp2_verification.text.toString().length == 1) {
                otpVerificationLayout.ed_otp3_verification.requestFocus()
            }
        }

        override fun afterTextChanged(s: Editable) {

        }
    }

    private val otpTextWatcherThree: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (otpVerificationLayout.ed_otp3_verification.text.toString().length == 1) {
                otpVerificationLayout.ed_otp4_verification.requestFocus()
            }
        }

        override fun afterTextChanged(s: Editable) {

        }
    }


    private val otpTextWatcherFour: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (otpVerificationLayout.ed_otp4_verification.text.toString().length == 1) {
                otpVerificationLayout.ed_otp4_verification.requestFocus()
            }

        }

        override fun afterTextChanged(s: Editable) {
            button_verify_otp_verification.isEnabled =
                otpVerificationLayout.ed_otp4_verification.text.toString().length == 1
        }
    }

    private fun getOtpVerification() {
        findNavController().navigate(
            R.id.action_otpFragment_to_homeFragment
        )
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentOtpVerificationBinding.inflate(inflater, container, false)
}