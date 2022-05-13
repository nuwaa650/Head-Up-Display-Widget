
+package com.example.speedometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.location.ActivityTransitionRequest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.material.chip.ChipDrawable
import pub.devrel.easypermissions.EasyPermissions
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(),EasyPermissions.PermissionCallbacks,
EasyPermissions.RationaleCallbacks
{
    private val TAG = "MainActivity"
    private val LOCATION_PERM = 124
    private val speedUpStartTime = 0L
    private val speedUpEndTime = 0L
    private val speedDownStartTime = 0L
    private val speedDownEndTime = 0L

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback
    private var isDone :Boolean by Delegates.observable(initialValue:false){property,oldValue,newValue->
        if (newValue == true)
        {
            fusedLocationProviderClient
        }
    }

//new one



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}