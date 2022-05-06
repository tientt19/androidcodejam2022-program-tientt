package com.example.rolldicer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            val resultTextView: TextView = findViewById(R.id.resultDiceRoller)
            val resultImageView: ImageView = findViewById(R.id.resultImageView)
            val myFirstDice = Dice(6)
            val rollResult = myFirstDice.roll()
            val luckyNumber = 4

            resultTextView.text = rollResult.toString()
            when (rollResult) {
                luckyNumber -> resultImageView.setImageResource(R.drawable.dice_4)
                1 -> resultImageView.setImageResource(R.drawable.dice_1)
                2 -> resultImageView.setImageResource(R.drawable.dice_2)
                3 -> resultImageView.setImageResource(R.drawable.dice_3)
                5 -> resultImageView.setImageResource(R.drawable.dice_5)
                6 -> resultImageView.setImageResource(R.drawable.dice_6)
            }
        }
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}