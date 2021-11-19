package com.example.readcontacts

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private var isPermission = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // Request to the use for permission
            requestPermissions(Array(1) { Manifest.permission.READ_CONTACTS }, 1009)
        } else {
            Log.d(TAG, "onCreate: ReadContact")
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d(TAG, "onRequestPermissionsResult: requestCode $requestCode")
        Log.d(TAG, "onRequestPermissionsResult: permissions ${permissions.size}")
        Log.d(TAG, "onRequestPermissionsResult: permissions ${permissions[0]}")
        Log.d(TAG, "onRequestPermissionsResult: grantResults ${grantResults.size}")
        Log.d(TAG, "onRequestPermissionsResult: grantResults ${grantResults[0]}")

        if (requestCode == 1009 && grantResults[0] == 0) {
            Log.d(TAG, "onRequestPermissionsResult: ReadContact")

        }
    }


}