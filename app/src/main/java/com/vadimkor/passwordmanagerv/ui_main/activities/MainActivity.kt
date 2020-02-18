package com.vadimkor.passwordmanagerv.ui_main.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.vadimkor.passwordmanagerv.R
import com.vadimkor.passwordmanagerv.ui_main.fragments.blank_fragment.BlankFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        _replaceFragment(BlankFragment())
    }

    private fun _replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_activity_container, fragment)
       // transaction.addToBackStack(null)
        transaction.commit()
    }
}
