package com.vadimkor.passwordmanagerv.access.fragments.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.vadimkor.passwordmanagerv.MainActivity
import com.vadimkor.passwordmanagerv.R
import com.vadimkor.passwordmanagerv.access.EMPTY
import com.vadimkor.passwordmanagerv.access.PIN_CODE
import com.vadimkor.passwordmanagerv.access.myPreferences
import com.vadimkor.passwordmanagerv.extension.toast
import kotlinx.android.synthetic.main.insert_pin_fragment.*

class InsertPin : Fragment() {

    companion object {
        fun newInstance() = InsertPin()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.insert_pin_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sharedPreferences = this.activity!!.getSharedPreferences(
            myPreferences,
            Context.MODE_PRIVATE
        )

        val pin_code = sharedPreferences.getString(PIN_CODE, EMPTY)
        var password = ""

        tv_clear.setOnClickListener {
            iv_1.visibility = View.INVISIBLE
            iv_2.visibility = View.INVISIBLE
            iv_3.visibility = View.INVISIBLE
            iv_4.visibility = View.INVISIBLE
            password = ""
        }

        val listener = View.OnClickListener { v ->
            val b = v as Button
            password += b.text.toString()

            when (password.length) {
                1 -> iv_1.visibility = View.VISIBLE
                2 -> iv_2.visibility = View.VISIBLE
                3 -> iv_3.visibility = View.VISIBLE
                4 -> {
                    iv_4.visibility = View.VISIBLE
                    if (password == pin_code) {
                        val intent = Intent(context, MainActivity::class.java)
                        startActivity(intent)
                        activity!!.finish()
                    } else {
                        toast(context!!, "Password wrong")
                        iv_1.visibility = View.INVISIBLE
                        iv_2.visibility = View.INVISIBLE
                        iv_3.visibility = View.INVISIBLE
                        iv_4.visibility = View.INVISIBLE
                        password = ""
                    }
                }
            }
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
    }
}
