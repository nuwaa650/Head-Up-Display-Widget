package com.example.hud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val buttonClick1 = findViewById<Button>(R.id.backbtn)
        buttonClick1.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val buttonClick2 = findViewById<Button>(R.id.editbtn)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, Edituser::class.java)
            startActivity(intent)
        }
    }
}