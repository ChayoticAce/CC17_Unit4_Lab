package com.chayoticace.cc17_unit4_lab

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


/*Select tasks activity that displays five buttons.
Handle the click event of each button. And in each click,
fire an implicit intent that will go to an activity in an external app.

First three tasks must successfully navigate to the activity.
Fourth and fifth task must fail intentionally and handle the error in a graceful way such as displaying the appropriate message.
Indicate the cause of the error in the form of a comment. The cause of the error shouldn't be a syntax error or any obvious error. i.e: //The intent failed due to...

Each task must not be part of the examples that I have shown in the video discussion.*/

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        findViewById<Button>(R.id.button1).setOnClickListener{btn1()}
        findViewById<Button>(R.id.button2).setOnClickListener{btn2()}
        findViewById<Button>(R.id.button3).setOnClickListener{btn3()}
    }

    //
    private fun btn1(){
        val REQUEST_VIDEO_CAPTURE = 1

        Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { takeVideoIntent ->
            takeVideoIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE)
            }
        }

    }
    private fun btn2(){
        val uri = Uri.parse("http://www.google.com") // missing 'http://' will cause crashed

        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun btn3(){
        val gmmIntentUri = Uri.parse("geo:16.408762, 120.597803")

        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
    }

}