package com.example.toastapplicaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.toastlibrary.CustomSnackbar

class MainActivity : AppCompatActivity() {

    private lateinit var btnShowToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast = findViewById(R.id.btn_show_toast)

        btnShowToast.setOnClickListener {
            val parentView: View = findViewById(android.R.id.content)
            val customSnackbar = CustomSnackbar.make(this, parentView, "Custom Snackbar Message", 10)
            customSnackbar.show()
        }
    }

}