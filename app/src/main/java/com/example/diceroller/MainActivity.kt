package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll dice and update
     */
    private fun rollDice() {
        val dice = Dice(6)
        val luckyNumber = 6
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val textDice: TextView = findViewById(R.id.textView)
        val textDice2: TextView = findViewById(R.id.textView2)
        var rollResult = dice.roll()
        var textToShow = ""
        var arrayResult = listOf("So sorry! You rolled a ${rollResult}. Try again!",
                "Sadly, you rolled a ${rollResult}. Try again!",
                "Unfortunately, you rolled a ${rollResult}. Try again!",
                "No luck! You rolled a ${rollResult}. Try again!",
                "Don't cry! You rolled a ${rollResult}. Try again!",
                "Apologies! you rolled a ${rollResult}. Try again!")

        //val resultTextView: TextView = findViewById(R.id.textView)
        //val resultTextView2: TextView = findViewById(R.id.textView2)
        //diceImage.setImageResource(R.drawable.dice_2)
        //diceImage2.setImageResource(R.drawable.dice_2)
        //resultTextView.text = dice.roll().toString()
        //resultTextView2.text = dice.roll().toString()
        diceImage.contentDescription = rollResult.toString()
        if (rollResult == luckyNumber) {
            textDice.text = "Lucky Number: ${luckyNumber} !"
        } else {
            textDice.text = arrayResult[(0..5).random()]
        }

        when (rollResult) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        rollResult = dice.roll()
        diceImage2.contentDescription = rollResult.toString()
        arrayResult = listOf("So sorry! You rolled a ${rollResult}. Try again!",
                "Sadly, you rolled a ${rollResult}. Try again!",
                "Unfortunately, you rolled a ${rollResult}. Try again!",
                "No luck! You rolled a ${rollResult}. Try again!",
                "Don't cry! You rolled a ${rollResult}. Try again!",
                "Apologies! you rolled a ${rollResult}. Try again!")

        if (rollResult == luckyNumber) {
            textDice2.text = "Lucky Number: ${luckyNumber} !"
        } else {
            textDice2.text = arrayResult[(0..5).random()]
        }
        when (rollResult) {
            1 -> diceImage2.setImageResource(R.drawable.dice_1)
            2 -> diceImage2.setImageResource(R.drawable.dice_2)
            3 -> diceImage2.setImageResource(R.drawable.dice_3)
            4 -> diceImage2.setImageResource(R.drawable.dice_4)
            5 -> diceImage2.setImageResource(R.drawable.dice_5)
            6 -> diceImage2.setImageResource(R.drawable.dice_6)
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}