package com.vadimkor.passwordmanagerv.access.fragments.add_pin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vadimkor.passwordmanagerv.MainActivity
import com.vadimkor.passwordmanagerv.R
import com.vadimkor.passwordmanagerv.access.*
import com.vadimkor.passwordmanagerv.extension.toast
import kotlinx.android.synthetic.main.add_pin_code_fragment.*

class AddPinCode : Fragment() {

    companion object {
        fun newInstance() =
            AddPinCode()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_pin_code_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sharedPreferences = this.activity!!.getSharedPreferences(
            myPreferences,
            Context.MODE_PRIVATE
        )

        button_save_pw.setOnClickListener {
            //If the user has left any fields empty, show Toast message
            if (et_create_password.text.toString() == EMPTY
                || et_create_password_2.text.toString() == EMPTY
            ) {
                toast(context!!, ERROR_INPUT_EMPTY)

            } else if (et_create_password.text.toString() != et_create_password_2.text.toString()) {
                toast(context!!, "Passwords do not match!!! ")
            } else if (et_create_password.text.toString().length < 4) {
                toast(context!!, "Passwords is too short ")
            } else {
                //If all fields are filled then fetch the data and
                // save the data in Shared Preferences
                val editor = sharedPreferences.edit()
                editor.putString(PIN_CODE, et_create_password.text.toString())
                editor.apply()

                toast(context!!, SAVED)
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                activity!!.finish()
            }
        }
    }
}
