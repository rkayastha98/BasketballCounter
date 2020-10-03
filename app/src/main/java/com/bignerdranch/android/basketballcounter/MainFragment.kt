package com.bignerdranch.android.basketballcounter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main_activity.*

class MainFragment: Fragment() {
    private lateinit var threeButtonA: Button
    private lateinit var twoButtonA: Button
    private lateinit var freeA: Button
    private lateinit var threeButtonB: Button
    private lateinit var twoButtonB: Button
    private lateinit var freeB: Button
    private lateinit var reset: Button
    private lateinit var save: Button
    private lateinit var display: Button
    private lateinit var A_score: TextView
    private lateinit var B_score: TextView
    private lateinit var team_A: EditText
    private lateinit var team_B: EditText

    private lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainFragment= MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_activity, container, false)
        threeButtonA=view.findViewById(R.id.A_three)
        twoButtonA=view.findViewById(R.id.A_two)
        freeA=view.findViewById(R.id.A_free)
        threeButtonB=view.findViewById(R.id.B_three)
        twoButtonB=view.findViewById(R.id.B_two)
        freeB=view.findViewById(R.id.B_free)
        reset=view.findViewById(R.id.reset)
        save=view.findViewById(R.id.saveBtn)
        display=view.findViewById(R.id.displayBtn)
        A_score=view.findViewById(R.id.team_A_score)
        B_score=view.findViewById(R.id.team_B_score)
        team_A=view.findViewById(R.id.team_A)
        team_B=view.findViewById(R.id.team_B)

        threeButtonA.setOnClickListener{
            A_score.text=(activity as MainActivity?)?.updateA(3)
        }

        twoButtonA.setOnClickListener {
            A_score.text=(activity as MainActivity?)?.updateA(2)
        }

        freeA.setOnClickListener {
            A_score.text=(activity as MainActivity?)?.updateA(1)
        }

        threeButtonB.setOnClickListener {
            B_score.text=(activity as MainActivity?)?.updateB(3)
        }

        twoButtonB.setOnClickListener {
            B_score.text=(activity as MainActivity?)?.updateB(2)
        }

        freeB.setOnClickListener {
            B_score.text=(activity as MainActivity?)?.updateB(1)
        }

        reset.setOnClickListener {
            (activity as MainActivity?)?.update()
            A_score.text="0"
            B_score.text="0"

        }

        save.setOnClickListener{
            val msg_teamA = team_A.getText().toString()
            val msg_teamB = team_B.getText().toString()

            (activity as MainActivity?)?.intentStart(msg_teamA,msg_teamB)
        }

        display.setOnClickListener{

        }

        return view
    }



}