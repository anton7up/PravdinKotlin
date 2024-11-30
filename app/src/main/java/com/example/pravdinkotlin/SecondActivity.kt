package com.example.pravdinkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sendNameButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nameEditText = findViewById(R.id.nameEditText)
        sendNameButton = findViewById(R.id.sendNameButton)

        sendNameButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("USER_NAME", name)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
