package com.vadimkor.passwordmanagerv.ui_access

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.vadimkor.passwordmanagerv.R
import com.vadimkor.passwordmanagerv.ui_access.fragments.add_pin.AddPinCode
import com.vadimkor.passwordmanagerv.ui_access.fragments.login.InsertPin

const val EMPTY = ""
const val ERROR_INPUT_EMPTY = "Please fill all fields"
const val SAVED = "Saved!"
const val myPreferences = "myPreferences"
const val PIN_CODE = "pin_code"

class PinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)

        val sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)

        if (sharedPreferences.getString(PIN_CODE, EMPTY) != EMPTY) {
            replaceFragment(InsertPin())
        } else {
            replaceFragment(AddPinCode())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_pin_code, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        finish()
    }
}

