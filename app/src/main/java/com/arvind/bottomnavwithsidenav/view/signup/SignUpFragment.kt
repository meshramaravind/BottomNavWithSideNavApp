package com.arvind.bottomnavwithsidenav.view.signup

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.arvind.bottomnavwithsidenav.R
import com.arvind.bottomnavwithsidenav.databinding.FragmentSignUpBinding
import com.arvind.bottomnavwithsidenav.view.base.BaseFragment
import com.arvind.bottomnavwithsidenav.viewmodel.signup.SignUpViewModel
import com.arvind.demoappbottom.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.util.regex.Pattern

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>() {

    override val viewModel: SignUpViewModel by viewModels()
    lateinit var stringFirstName: String
    lateinit var stringLastName: String
    lateinit var stringEmail: String
    lateinit var stringMobile: String
    lateinit var stringPassword: String
    lateinit var stringState: String
    lateinit var stringCity: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initsView()
    }

    private fun initsView() = with(binding) {
        getSignUpTextWatcher()
        buttonContinueSignup.setOnClickListener {
            hideKeyboard()
            stringFirstName = edFirstNameSignup.text.toString().trim()
            stringLastName = edLastNameSignup.text.toString().trim()
            stringEmail = edEmailSignup.text.toString().trim()
            stringMobile = edContactNumberSignup.text.toString().trim()
            stringPassword = edPasswordSignup.text.toString().trim()


            if (!validateUserFirstName() or !validateUserLastName() or !validateUserEmail()
                or !validateUserMobile() or !validateUserPassword()
            ) {
                return@setOnClickListener
            } else {
                getSignUP()
            }


        }
    }

    private fun getSignUpTextWatcher() {
        ed_first_name_signup.addTextChangedListener(firstNameTextWatcher)
        ed_last_name_signup.addTextChangedListener(lastNameTextWatcher)
        ed_email_signup.addTextChangedListener(emailTextWatcher)
        ed_contact_number_signup.addTextChangedListener(mobileNumberTextWatcher)
        ed_password_signup.addTextChangedListener(passwordTextWatcher)
    }


    private fun validateUserFirstName(): Boolean {
        if (ed_first_name_signup.text.toString()
                .isEmpty()
        ) {
            tv_text_error_first_name_signup.error = tv_text_error_first_name_signup.error
            tv_text_error_first_name_signup.setTextColor(Color.RED)
            tv_text_error_first_name_signup.visibility = View.VISIBLE

            return false
        } else {
            tv_text_error_first_name_signup.isEnabled = false
            tv_text_error_first_name_signup.visibility = View.GONE
            tv_text_error_first_name_signup.error = null
        }

        return true

    }

    private fun validateUserLastName(): Boolean {

        if (ed_last_name_signup.text.toString()
                .isEmpty()
        ) {
            tv_text_error_last_name_sign_up.error = tv_text_error_last_name_sign_up.error
            tv_text_error_last_name_sign_up.setTextColor(Color.RED)
            tv_text_error_last_name_sign_up.visibility = View.VISIBLE

            return false
        } else {
            tv_text_error_last_name_sign_up.isEnabled = false
            tv_text_error_last_name_sign_up.visibility = View.GONE
            tv_text_error_last_name_sign_up.error = null
        }

        return true
    }

    private fun validateUserEmail(): Boolean {
        val email: String =
            ed_email_signup.text.toString().trim()

        if (ed_email_signup.text.toString()
                .isEmpty() or !isValidEmailAddress(email)
        ) {
            tv_text_error_email_sign_up.error =
                tv_text_error_email_sign_up.error
            tv_text_error_email_sign_up.visibility = View.VISIBLE
            tv_text_error_email_sign_up.setTextColor(Color.RED)

            return false
        } else {
            tv_text_error_email_sign_up.isEnabled = false
            tv_text_error_email_sign_up.visibility = View.GONE
            tv_text_error_email_sign_up.error = null
        }

        return true

    }

    private fun isValidEmailAddress(email: String): Boolean {
        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"

        val pat = Pattern.compile(emailRegex)
        return pat.matcher(email).matches()

    }

    private fun validateUserMobile(): Boolean {

        val mobile: String =
            ed_contact_number_signup.text.toString().trim()

        if (ed_contact_number_signup.text.toString()
                .isEmpty() or !isValidMobileNumber(mobile)
        ) {
            tv_text_error_contact_number_sign_up.error =
                tv_text_error_contact_number_sign_up.error
            tv_text_error_contact_number_sign_up.visibility = View.VISIBLE
            tv_text_error_contact_number_sign_up.setTextColor(Color.RED)

            return false
        } else {
            tv_text_error_contact_number_sign_up.isEnabled = false
            tv_text_error_contact_number_sign_up.visibility = View.GONE
            tv_text_error_contact_number_sign_up.error = null
        }

        return true
    }

    private fun isValidMobileNumber(mobile: String): Boolean {
        val p = Pattern.compile("(0/91)?[7-9][0-9]{9}")

        val m = p.matcher(mobile)
        return m.find() && m.group() == mobile

    }

    private fun validateUserPassword(): Boolean {
        if (ed_password_signup.text.toString()
                .isEmpty() or !isValidPassword(ed_password_signup.text.toString())
        ) {
            tv_text_error_password_sign_up.error = tv_text_error_password_sign_up.error
            tv_text_error_password_sign_up.setTextColor(Color.RED)
            tv_text_error_password_sign_up.visibility = View.VISIBLE

            return false
        } else {
            tv_text_error_password_sign_up.isEnabled = false
            tv_text_error_password_sign_up.visibility = View.GONE
            tv_text_error_password_sign_up.error = null
        }

        return true
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

    private val firstNameTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable) {
            validateUserFirstName()
        }
    }


    private val lastNameTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable) {
            validateUserLastName()
        }
    }

    private val emailTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable) {
            validateUserEmail()
        }
    }


    private val mobileNumberTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable) {
            validateUserMobile()

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


    private fun getSignUP() {
        findNavController().navigate(R.id.action_SignUpFragment_to_otpFragment)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSignUpBinding.inflate(inflater, container, false)
}