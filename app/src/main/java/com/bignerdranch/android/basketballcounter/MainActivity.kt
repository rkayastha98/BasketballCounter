package com.bignerdranch.android.basketballcounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity"
private const val KEY_INDEX = "index"

class MainActivity : AppCompatActivity() {
    private lateinit var threeButtonA:Button
    private lateinit var twoButtonA:Button
    private lateinit var freeA:Button
    private lateinit var threeButtonB:Button
    private lateinit var twoButtonB:Button
    private lateinit var freeB:Button
    private lateinit var reset:Button
    private lateinit var save:Button
    private lateinit var display:Button
    private lateinit var A_score:TextView
    private lateinit var B_score:TextView
    private lateinit var team_A:EditText
    private lateinit var team_B:EditText


    private val bbBallViewModel: BasketballCounterViewModel by lazy {
        ViewModelProviders.of(this).get(BasketballCounterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val bbBallViewModel = provider.get(BasketballCounterViewModel::class.java)
        Log.d(TAG, "Got a ViewModel: $bbBallViewModel")

        threeButtonA=findViewById(R.id.A_three)
        twoButtonA=findViewById(R.id.A_two)
        freeA=findViewById(R.id.A_free)
        threeButtonB=findViewById(R.id.B_three)
        twoButtonB=findViewById(R.id.B_two)
        freeB=findViewById(R.id.B_free)
        reset=findViewById(R.id.reset)
        save=findViewById(R.id.saveBtn)
        display=findViewById(R.id.displayBtn)
        A_score=findViewById(R.id.team_A_score)
        B_score=findViewById(R.id.team_B_score)
        team_A=findViewById(R.id.team_A)
        team_B=findViewById(R.id.team_B)

        threeButtonA.setOnClickListener{
            bbBallViewModel.updateAScore(3)
            updateScore()

        }

        twoButtonA.setOnClickListener {
            bbBallViewModel.updateAScore(2)
            updateScore()
        }

        freeA.setOnClickListener {
            bbBallViewModel.updateAScore(1)
            updateScore()
        }

        threeButtonB.setOnClickListener {
            bbBallViewModel.updateBScore(3)
            updateScore()
        }

        twoButtonB.setOnClickListener {
            bbBallViewModel.updateBScore(2)
            updateScore()
        }

        freeB.setOnClickListener {
            bbBallViewModel.updateBScore(1)
            updateScore()
        }

        reset.setOnClickListener {
            bbBallViewModel.resetScore()
            updateScore()
        }

        save.setOnClickListener{
            val intent=Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        display.setOnClickListener{

        }
        updateScore()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(KEY_INDEX, bbBallViewModel.current_a_score)
    }

    fun updateScore(){
        A_score.text=bbBallViewModel.current_a_score.toString()
        B_score.text=bbBallViewModel.current_b_score.toString()
    }


}