package com.example.ardin.eatit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sign up button action
        btnSignUp.setOnClickListener {
            println("MASUK SINI")
        }

        //active button action
        btnSignActive.setOnClickListener {

            println("MASUK SINI")
        }
    }
}
