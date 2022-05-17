package com.example.hud

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Compass : AppCompatActivity() {

    private lateinit var txt: TextView

    var f = -45f
    var cmpVal =0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compass)


        var sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var list =sm.getSensorList(Sensor.TYPE_ORIENTATION)
        var se = object : SensorEventListener {
            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

            }

            override fun onSensorChanged(sensorEvent: SensorEvent?) {
                var values = sensorEvent?.values

                var z = values?.get(0);
                var y = values?.get(1);
                var x = values?.get(2);

                if (z != null) {
                    // allowed if nullableInt could not have changed since the null check
                    var nonNullableFloat: Float = z
                    cmpVal=nonNullableFloat
                    AnimateRocket()

                }




            }
        }
        sm.registerListener(se, list.get(0), SensorManager.SENSOR_DELAY_NORMAL)

        val buttonClick = findViewById<Button>(R.id.backbtn)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }


    private fun AnimateRocket(){
        txt = findViewById(R.id.compassval)
        txt.setText("$cmpVal")
    }
}