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

class Landmeter : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var image2: ImageView
    var startPoint = -45f
    var startPoint2 = -45f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmeter)

        var sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var list =sm.getSensorList(Sensor.TYPE_ORIENTATION)
        var se = object : SensorEventListener {
            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

            }

            override fun onSensorChanged(sensorEvent: SensorEvent?) {
                var values = sensorEvent?.values
                var z = values?.get(0);
                var y = values?.get(1);//pitch
                var x = values?.get(2);//roll
                if (x != null && y != null) {
                    // allowed if nullableInt could not have changed since the null check
                    var nonNullableFloatY: Float = x
                    var nonNullableFloatX: Float = y*-1

                    AnimatePitch(nonNullableFloatY)
                    AnimateRoll(nonNullableFloatX)
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

    private fun AnimatePitch(pitch:Float) {

        var mRotateUpAnim: RotateAnimation
        mRotateUpAnim = RotateAnimation(
            startPoint, pitch ,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f
        );

        mRotateUpAnim.duration = 500
        image = findViewById(R.id.pitchingcar)
        image.startAnimation(mRotateUpAnim)
        startPoint=pitch
    }

    private fun AnimateRoll(roll:Float) {

        var mRotateUpAnim: RotateAnimation
        mRotateUpAnim = RotateAnimation(
            roll, startPoint2 ,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f
        );

        mRotateUpAnim.duration = 500
        image2 = findViewById(R.id.rollingcar)
        image2.startAnimation(mRotateUpAnim)
        startPoint2=roll
    }
}