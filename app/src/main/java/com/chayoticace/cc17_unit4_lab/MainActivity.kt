package com.chayoticace.cc17_unit4_lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/*Create a multi tasker app that has two activities:

Login activity that accepts the username and password. If the credentials are correct then navigate to the other activity.

Select tasks activity that displays five buttons.
Handle the click event of each button. And in each click,
fire an implicit intent that will go to an activity in an external app.

First three tasks must successfully navigate to the activity.
Fourth and fifth task must fail intentionally and handle the error in a graceful way such as displaying the appropriate message.
Indicate the cause of the error in the form of a comment. The cause of the error shouldn't be a syntax error or any obvious error. i.e: //The intent failed due to...

Each task must not be part of the examples that I have shown in the video discussion.

Upload your initial code in your Github repository
Afterwards, work on the activity and create a commit that contains the code for your activity.

Submit the link for the Github commit and screen recording as proof that your code is working as intended.*/
//---------------------------------------------------------------------------------------------------------------

//This should be the login activity
//that accepts the username and password. If the credentials are correct then navigate to the other activity.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.mainact_button1).setOnClickListener{foo()}
    }

    private fun foo(){
        val intent = Intent (this, Activity2::class.java)
        startActivity(intent)
    }
}