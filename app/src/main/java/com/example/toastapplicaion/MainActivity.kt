package com.example.toastapplicaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.toastlibrary.CustomSnackbar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parentView: View = findViewById(android.R.id.content)
        val customSnackbar = CustomSnackbar.make(this, parentView, "Custom Snackbar Message", 10)
        customSnackbar.show()
    }
}