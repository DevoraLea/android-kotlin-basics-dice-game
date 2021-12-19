package com.example.dicegame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var level = 1
    var tryRollDice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTextOfLevel()
        btnRollDice.setOnClickListener(View.OnClickListener {rollDice() })
        btnPlayAgain.setOnClickListener(View.OnClickListener {newGame()})
    }
    fun rollDice(){
        val dice = Dice(6)
        val valueDice =  dice.rollDice()

        changeImageDice(valueDice)
        checkPassLevel(valueDice)
    }
    fun changeImageDice(valueDice: Int){
        val imageSrc = when(valueDice){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6
        }
        imgValueDice.contentDescription = valueDice.toString()
        imgValueDice.setImageResource(imageSrc)
    }
    fun checkPassLevel(valueDice:Int)
    {
        if (level == valueDice){
            messageUSer("YOU GET A POINT")
            nextLevel()
            changeTextColor(Color.GREEN)
        }
        else{
            messageUSer("NOT THIS TIME")
            tryRollDice += 1
            txtTries.text = "${tryRollDice} try"
            changeTextColor(Color.RED)
        }
    }
    fun messageUSer(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
    fun changeTextColor(color:Int){
        txtTries.setBackgroundColor(color)
    }
    fun nextLevel(){
        if(level < 6) {
            level += 1
            setTextOfLevel()
        }else{
            messageUSer("GAME OVER :),YOU WIN")
            btnRollDice.isEnabled = false
            btnPlayAgain.visibility = View.VISIBLE
        }
    }
    fun setTextOfLevel(){
        txtLevelGame.text = LevelGame().levelGame.get(level-1)
        txtInstuctionLevel.text = LevelGame().instuctionGame.get(level-1)
    }
    fun newGame(){
        level = 1
        setTextOfLevel()
        btnPlayAgain.visibility = View.GONE
        btnRollDice.isEnabled = true
        tryRollDice = 0
        changeTextColor(Color.BLACK)
        txtTries.text = "${tryRollDice} try"
    }
}