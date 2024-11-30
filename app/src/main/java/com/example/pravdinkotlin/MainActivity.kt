package com.example.pravdinkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var greetingTextView: TextView
    private lateinit var openSecondActivityButton: Button
    private val secondActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            greetingTextView.text = "Привет, " + it.data?.getStringExtra("USER_NAME").toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetingTextView = findViewById(R.id.greetingTextView)
        openSecondActivityButton = findViewById(R.id.openSecondActivityButton)

        openSecondActivityButton.setOnClickListener {
            secondActivityResult.launch(Intent(this, SecondActivity::class.java))
        }
    }
}
