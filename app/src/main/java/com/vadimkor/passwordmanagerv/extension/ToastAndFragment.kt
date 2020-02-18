package com.vadimkor.passwordmanagerv.extension

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment

@Suppress("unused")
fun Any.toast(context: Context, message: String): Toast {
    return Toast.makeText(
        context, message, Toast.LENGTH_LONG
    ).apply { show() }
}

fun Fragment.hideKeyboard() {
    val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view!!.windowToken, 0)
}