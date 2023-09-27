package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textResult: TextView
    private var currentNumber = StringBuilder()
    private var operand1: Double? = null
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.textView)
        setupNumberButtons()
        setupOperatorButtons()
        setupEqualsButton()
        setupClearButton()

    }
    
    private fun appendNumber(view: View) {
        val button = view as Button
        currentNumber.append(button.text)
        textResult.text = currentNumber.toString()
    }

    private fun setOperator(view: View) {
        val button = view as Button
        operator = button.text.toString()
        operand1 = currentNumber.toString().toDouble()
        currentNumber.clear()
    }
    private fun calculate() {
        val operand2 = currentNumber.toString().toDouble()
        var result = 0.0

        when (operator) {
            "+" -> result = operand1!! + operand2
            "-" -> result = operand1!! - operand2
            "*" -> result = operand1!! * operand2
            "/" -> result = operand1!! / operand2
        }

        textResult.text = result.toString()
        currentNumber.clear()
        currentNumber.append(result)
    }

    private fun clear() {
        currentNumber.clear()
        textResult.text = ""
    }

    private fun setupNumberButtons() {
        val numberButtons = arrayOf(
            R.id.button17, R.id.button18, R.id.button19, R.id.button13, R.id.button14,
            R.id.button15, R.id.button9, R.id.button10, R.id.button10, R.id.button11
        )

        for (buttonId in numberButtons) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener { appendNumber(it) }
        }
    }

    private fun setupOperatorButtons() {
        val operatorButtons = arrayOf(
            R.id.button20, R.id.button12, R.id.button16, R.id.button7
        )

        for (buttonId in operatorButtons) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                if (currentNumber.isNotEmpty()) {
                    setOperator(it)
                }
            }
        }
    }

    private fun setupEqualsButton() {
        val equalsButton = findViewById<Button>(R.id.button21)
        equalsButton.setOnClickListener {
            if (currentNumber.isNotEmpty() && operator != null) {
                calculate()
            }}
    }

    private fun setupClearButton() {
        val clearButton = findViewById<Button>(R.id.button6)
        clearButton.setOnClickListener { clear() }
    }



    fun ButtonClick(view: View) {
        val b1 = findViewById<Button>(R.id.button17)
        val b2 = findViewById<Button>(R.id.button18)
        val b3 = findViewById<Button>(R.id.button19)
        val b4 = findViewById<Button>(R.id.button13)
        val b5 = findViewById<Button>(R.id.button14)
        val b6 = findViewById<Button>(R.id.button15)
        val b7 = findViewById<Button>(R.id.button9)
        val b8 = findViewById<Button>(R.id.button10)
        val b9 = findViewById<Button>(R.id.button11)

        val c = findViewById<Button>(R.id.button6)

        val textView = findViewById<TextView>(R.id.textView)

        if (view is Button) {
            val bn : Button = view as Button
            textView.setText(textView.text.toString() + bn.text.toString())
        }

        c.setOnClickListener{
            textView.text= ""
        }

    }
}