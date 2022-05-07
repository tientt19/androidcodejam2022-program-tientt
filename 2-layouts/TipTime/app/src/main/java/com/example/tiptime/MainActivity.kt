package com.example.tiptime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.NumberFormat

@SuppressLint("UseSwitchCompatOrMaterialCode")

class MainActivity : AppCompatActivity() {
    // layout components
    private val costTextField: EditText = findViewById(R.id.cost_of_service)
    private val tipOptions: RadioGroup = findViewById(R.id.tip_options)
    private val roundUpSwitch: Switch = findViewById(R.id.round_up_switch)
    private val tipResult: TextView = findViewById(R.id.tip_result)
    private val calculateButton: Button = findViewById(R.id.calculate_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val stringInTextField = costTextField.toString()
        val cost = stringInTextField.toDoubleOrNull()

        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        val tipPercentage = when(tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = roundUpSwitch.isChecked

        if(roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        displayTip(tip)
    }

    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        tipResult.text = formattedTip.toString()
    }
}