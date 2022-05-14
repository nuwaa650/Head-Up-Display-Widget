package com.example.hud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Toast.makeText(this,"welcome", Toast.LENGTH_SHORT).show()

        val buttonClick1 = findViewById<Button>(R.id.speedometerbtn)
        buttonClick1.setOnClickListener {
            val intent = Intent(this, Speedometer::class.java)
            startActivity(intent)
        }

        val buttonClick2 = findViewById<Button>(R.id.landmeterbtn)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, Landmeter::class.java)
            startActivity(intent)
        }

        val buttonClick3 = findViewById<Button>(R.id.compassbtn)
        buttonClick3.setOnClickListener {
            val intent = Intent(this, Compass::class.java)
            startActivity(intent)
        }

        val buttonClick4 = findViewById<Button>(R.id.navigationbtn)
        buttonClick4.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        val buttonClick5 = findViewById<Button>(R.id.tripinfobtn)
        buttonClick5.setOnClickListener {
            val intent = Intent(this, Tripinfo::class.java)
            startActivity(intent)
        }
        val buttonClick6 = findViewById<Button>(R.id.userbtn)
        buttonClick6.setOnClickListener {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
        }

    }
}