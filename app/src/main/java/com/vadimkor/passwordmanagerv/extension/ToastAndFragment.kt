package com.vadimkor.passwordmanagerv.extension

import android.content.Context
import android.widget.Toast

@Suppress("unused")
fun Any.toast(context: Context, message: String): Toast {
    return Toast.makeText(
        context, message, Toast.LENGTH_LONG
    ).apply { show() }
}