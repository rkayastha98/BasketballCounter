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
import kotlinx.android.synthetic.main.fragment_main_activity.*

private const val TAG = "MainActivity"
private const val KEY_INDEX = "index"

class MainActivity : AppCompatActivity() {

    private val bbBallViewModel: BasketballCounterViewModel by lazy {
        ViewModelProviders.of(this).get(BasketballCounterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val bbBallViewModel = provider.get(BasketballCounterViewModel::class.java)

        if(savedInstanceState==null){
            val currentFragment =
                supportFragmentManager.findFragmentById(R.id.fragment_container)

            if (currentFragment == null) {
                val fragment = MainFragment()
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
            }
        }

        update()
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
        savedInstanceState.putInt(KEY_INDEX, bbBallViewModel.current_b_score)
    }

    fun updateA(number: Int):String{
        bbBallViewModel.updateAScore(number)
        return bbBallViewModel.current_a_score.toString()

    }

    fun updateB(number: Int):String{
        bbBallViewModel.updateBScore(number)
        return bbBallViewModel.current_b_score.toString()
    }

    fun update(){
        bbBallViewModel.resetScore()
    }

    fun intentStart(msg_teamA:String,msg_teamB:String){

        val intent= Intent(this, SecondActivity::class.java).apply {
            putExtra("teamA",msg_teamA)
            putExtra("teamB",msg_teamB)
        }

        startActivity(intent)
    }





}