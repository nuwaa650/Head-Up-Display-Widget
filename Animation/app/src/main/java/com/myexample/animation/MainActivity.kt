package com.myexample.animation

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView
//    val formDegree  = 0
//    val toDegree  = 0
      var f = -45f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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
                if (y != null) {
                    // allowed if nullableInt could not have changed since the null check
                    var nonNullableFloat: Float = y
                    AnimateRocket(nonNullableFloat)
                    //var b=y;
                }

                //


            }
        }
        sm.registerListener(se, list.get(0), SensorManager.SENSOR_DELAY_NORMAL)




    }

    private fun AnimateRocket(roll:Float) {
//         val shake = AnimationUtils.loadAnimation(this, R.anim.shake_animation)
//             shake.duration=1000
//
//      image.startAnimation(shake)



        var mRotateUpAnim: RotateAnimation
        mRotateUpAnim = RotateAnimation(
                f, roll ,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f
        );
        //mRotateUpAnim.repeatCount = Int.MAX_VALUE
        //mRotateUpAnim.repeatMode = Animation.REVERSE
        mRotateUpAnim.duration = 500
        image = findViewById(R.id.imageView)
        image.startAnimation(mRotateUpAnim)
        f=roll
    }
}