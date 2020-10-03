package com.bignerdranch.android.basketballcounter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    private lateinit var cuteBtn:Button
    private lateinit var teamA:String
    private lateinit var teamB:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        teamA = intent.getStringExtra("teamA")
        teamB = intent.getStringExtra("teamB")

        cuteBtn=findViewById(R.id.cuteBtn)
    }

    fun cute(view: View){
        cuteBtn.isEnabled = false
    }


}