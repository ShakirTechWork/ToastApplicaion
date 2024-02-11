package com.example.toastlibrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.snackbar.Snackbar

class CustomSnackbar private constructor(private val context: Context, private val parentView: View) {

    private var snackbar: Snackbar? = null

    companion object {
        fun make(
            context: Context,
            parentView: View,
            title: CharSequence,
            subtitle: CharSequence,
            actionText: CharSequence,
            durationInSeconds: Int
        ): CustomSnackbar {
            return CustomSnackbar(context, parentView).apply {
                val layoutInflater = LayoutInflater.from(context)
                val layout: View = layoutInflater.inflate(R.layout.custom_toast_layout, null)

                val tvTitle: TextView = layout.findViewById(R.id.tv_title)
                val tvSubTitle: TextView = layout.findViewById(R.id.tv_sub_title)
                val tvAction: TextView = layout.findViewById(R.id.tv_action_text)
                val animationView = layout.findViewById<LottieAnimationView>(R.id.animation_view)

                // Set the Lottie animation
                animationView.setAnimation(R.raw.success_green_tick)
                animationView.playAnimation()

                tvTitle.text = title
                tvSubTitle.text = subtitle
                tvSubTitle.text = actionText

                snackbar = Snackbar.make(parentView, "", durationInSeconds * 1000)
                val snackbarView = snackbar?.view as Snackbar.SnackbarLayout

                snackbarView.addView(layout, 0) // Add your custom layout to the Snackbar
            }
        }
    }

    fun show() {
        snackbar?.show()
    }
}