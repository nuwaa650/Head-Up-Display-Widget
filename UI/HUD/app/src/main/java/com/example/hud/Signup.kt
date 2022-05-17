package com.example.hud

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class Signup : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        firebaseAuth = FirebaseAuth.getInstance()

        val buttonClick1 = findViewById<TextView>(R.id.signinlink)
        buttonClick1.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

//        val buttonClick2 = findViewById<TextView>(R.id.signup)
//        buttonClick2.setOnClickListener {
//
//            val VuserName = findViewById<EditText>(R.id.username)
//            val Vemail = findViewById<EditText>(R.id.email)
//            val Vpass = findViewById<EditText>(R.id.password)
//            val Vname = findViewById<EditText>(R.id.name)
//
//
//            firebaseAuth = FirebaseAuth.getInstance()
//
//            if (Vemail.text.isNotEmpty() && Vpass.text.isNotEmpty() && Vname.text.isNotEmpty()) {
//                if (Vpass == Vpass) {
//                        var em =Vemail.text.toString()
//                        var ev =Vpass.text.toString()
//                    firebaseAuth.createUserWithEmailAndPassword(em,ev).addOnCompleteListener {
//                        if (it.isSuccessful) {
//                            val intent = Intent(this, Login::class.java)
//                            startActivity(intent)
//                        } else {
//                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
//
//                        }
//                    }
//                } else {
//                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
//
//            }
//        }
    }
}