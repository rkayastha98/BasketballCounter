package com.bignerdranch.android.basketballcounter

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModel

private const val TAG="BasketballViewModel"

class BasketballCounterViewModel:ViewModel() {
    private var a_score= Score(R.id.team_A_score,0)
    private var b_score= Score(R.id.team_B_score,0)

    var current_a_score:Int = 0
        get() = a_score.num

    var current_b_score:Int = 0
        get() = b_score.num

    fun updateAScore(addNum:Int){
        a_score.num+=addNum
        Log.d(TAG,current_a_score.toString())
        current_a_score = a_score.num
    }

   fun updateBScore(addNum:Int){
       b_score.num+=addNum
       current_b_score = b_score.num
    }

    fun resetScore(){
        a_score.num=0
        b_score.num=0
        current_a_score = a_score.num
        current_b_score = b_score.num
    }
}