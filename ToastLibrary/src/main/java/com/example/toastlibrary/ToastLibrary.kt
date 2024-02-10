package com.example.toastlibrary

import android.content.Context
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class CustomSnackbar private constructor(private val context: Context, private val parentView: View) {

    private val handler: Handler = Handler(Looper.getMainLooper())
    private var snackbar: Snackbar? = null

    companion object {
        fun make(context: Context, parentView: View, message: CharSequence, durationInSeconds: Int): CustomSnackbar {
            return CustomSnackbar(context, parentView).apply {
                val layoutInflater = LayoutInflater.from(context)
                val layout: View = layoutInflater.inflate(R.layout.custom_toast_layout, null)

                val textView: TextView = layout.findViewById(R.id.toast_text)
                textView.text = message

                snackbar = Snackbar.make(parentView, "", durationInSeconds * 1000)
            }
        }
    }

    fun show() {
        snackbar?.show()
    }
}