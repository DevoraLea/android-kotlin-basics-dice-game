package com.example.dicegame

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun check_random(){
        val dice = Dice(6)
        val value = dice.rollDice()
    assertTrue("is not between 1 to 6", value in 1..6)
    }
}