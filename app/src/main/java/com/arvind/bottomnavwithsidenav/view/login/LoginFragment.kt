package com.arvind.bottomnavwithsidenav.view.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.arvind.bottomnavwithsidenav.R
import com.arvind.bottomnavwithsidenav.databinding.FragmentLoginBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragment
import com.arvind.bottomnavwithsidenav.viewmodel.login.LoginViewModel
import com.arvind.demoappbottom.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.regex.Pattern

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {
    override val viewModel: LoginViewModel by viewModels()
    lateinit var stringEmailOrMobile: String
    lateinit var stringPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initsView()
    }

    private fun initsView() = with(binding) {
        getLoginTextWatcher()
        getHideAndShowPassword()

        buttonSignIn.setOnClickListener {
            hideKeyboard()
            stringEmailOrMobile = edEmailOrPhoneNumberLogin.text.toString().trim()
            stringPassword = edPasswordLogin.text.toString().trim()

            if (!validateUserEmailOrMobile() or !validateUserPassword()) {
                return@setOnClickListener
            } else {
                getLogin()
            }
        }

    }

    private fun getLogin() {
        findNavController().navigate(R.id.action_SignInFragment_to_otpFragment)

    }

    private fun validateUserEmailOrMobile(): Boolean {

        val emailOrMobile: String =
            ed_email_or_phone_number_login.text.toString().trim()

        if (ed_email_or_phone_number_login.text.toString()
                .isEmpty() or !isValidEmailAddress(emailOrMobile) and !validMobileNumber(
                emailOrMobile
            )
        ) {
            tv_text_error_email_or_phone_number_login.error =
                tv_text_error_email_or_phone_number_login.error
            tv_text_error_email_or_phone_number_login.visibility = View.VISIBLE
            tv_text_error_email_or_phone_number_login.setTextColor(Color.RED)

            return false
        } else {
            tv_text_error_email_or_phone_number_login.isEnabled = false
            tv_text_error_email_or_phone_number_login.visibility = View.GONE
            tv_text_error_email_or_phone_number_login.error = null
        }

        return true
    }

    private fun validMobileNumber(emailOrMobile: String): Boolean {

        val p = Pattern.compile("(0/91)?[7-9][0-9]{9}")

        val m = p.matcher(emailOrMobile)
        return m.find() && m.group() == emailOrMobile
    }

    private fun validateUserPassword(): Boolean {
        if (ed_password_login.text.toString()
                .isEmpty() or !isValidPassword(ed_password_login.text.toString())
        ) {
            tv_text_error_password_sign_in.error = tv_text_error_password_sign_in.error
            tv_text_error_password_sign_in.setTextColor(Color.RED)
            tv_text_error_password_sign_in.visibility = View.VISIBLE

            return false
        } else {
            tv_text_error_password_sign_in.isEnabled = false
            tv_text_error_password_sign_in.visibility = View.GONE
            tv_text_error_password_sign_in.error = null
        }

        return true

    }


    private fun isValidEmailAddress(emailOrMobile: String): Boolean {

        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"

        val pat = Pattern.compile(emailRegex)
        return pat.matcher(emailOrMobile).matches()
    }

    private fun isValidPassword(password: String): Boolean {

        val regex = ("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$")

        val p = Pattern.compile(regex)
        val m = p.matcher(password)
        return m.matches()
    }


    private fun getLoginTextWatcher() {
        ed_email_or_phone_number_login.addTextChangedListener(emailOrMobileTextWatcher)
        ed_password_login.addTextChangedListener(passwordTextWatcher)
    }

    private fun getHideAndShowPassword() {
        image_button_hide_show_password_login.setOnClickListener {
            if (ed_password_login.transformationMethod
                    .equals(PasswordTransformationMethod.getInstance())
            ) {
                (it as ImageButton).setImageResource(R.drawable.ic_baseline_visibility_24)

                //Show Password
                ed_password_login.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
            } else {
                (it as ImageButton).setImageResource(R.drawable.ic_baseline_visibility_off_24)

                //Hide Password
                ed_password_login.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

    }

    private val emailOrMobileTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable) {
            validateUserEmailOrMobile()
        }
    }


    private val passwordTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable) {
            validateUserPassword()
        }
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)
}