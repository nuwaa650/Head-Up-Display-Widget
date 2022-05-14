package com.example.hud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Edituser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edituser)

        val buttonClick1 = findViewById<Button>(R.id.backbtn)
        buttonClick1.setOnClickListener {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
        }

    }
}