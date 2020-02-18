package com.vadimkor.passwordmanagerv.ui_main.fragments.add_user_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.vadimkor.passwordmanagerv.R
import com.vadimkor.passwordmanagerv.ui_main.fragments.blank_fragment.BlankFragment
import kotlinx.android.synthetic.main.add_user_fragment.*


class AddUserFragment : Fragment() { // R.layout.add_user_fragment

    companion object {
        fun newInstance() =
            AddUserFragment()
    }

    private lateinit var viewModel: AddUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddUserViewModel::class.java)

        btn_addUserFragment_add.setOnClickListener {

            when {
                et_addUserFragment_website.text.toString().isEmpty() -> et_addUserFragment_website.error =
                    "Please insert Website"
                et_addUserFragment_username_or_email.text.toString().isEmpty() -> et_addUserFragment_username_or_email.error =
                    "Please insert Login"
                et_addUserFragment_password.text.toString().isEmpty() -> et_addUserFragment_password.error =
                    "Please insert Password"
                else -> {
                    Snackbar.make(it, "Record successfully added ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()

                    viewModel.addUser(
                        et_addUserFragment_website.text.toString(),
                        et_addUserFragment_username_or_email.text.toString(),
                        et_addUserFragment_password.text.toString()
                    )

                    val transaction: FragmentTransaction =
                        activity!!.supportFragmentManager.beginTransaction()
                    transaction.replace(
                        R.id.main_activity_container,
                        BlankFragment()
                    )
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        }
    }
}
