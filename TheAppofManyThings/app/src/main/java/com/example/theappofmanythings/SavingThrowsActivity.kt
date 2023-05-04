package com.example.theappofmanythings

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SavingThrowsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.saving_throws)

        val backButton = findViewById<Button>(com.example.theappofmanythings.R.id.backButton)
        val strengthReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.strengthReplace)
        val dexReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.dexReplace)
        val constReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.constReplace)
        val intReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.intReplace)
        val wisReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.wisReplace)
        val charReplace = findViewById<TextView>(com.example.theappofmanythings.R.id.charReplace)

        val strength = character.getStrength()
        val dexterity = character.getDex()
        val constitution = character.getConst()
        val intelligence = character.getIntelligence()
        val wisdom = character.getWis()
        val charisma = character.getCharisma()

        strengthReplace.text = strength?.let { statModifier(it).toString() }
        dexReplace.text = dexterity?.let { statModifier(it).toString() }
        constReplace.text = constitution?.let { statModifier(it).toString() }
        intReplace.text = intelligence?.let { statModifier(it).toString() }
        wisReplace.text = wisdom?.let { statModifier(it).toString() }
        charReplace.text = charisma?.let { statModifier(it).toString() }

        backButton.setOnClickListener {
            onBackPressed()
        }



    }

    fun statModifier(x: Int): Int {
        // Saving Throw Modifier = Corresponding Ability Score Modifier + Your Proficiency Bonus (if proficient)
        if (x<2)
        {
            return -5
        }
        if (x<4)
            return -4
        if (x<6)
            return -3
        if (x<8)
            return -2
        if (x<10)
            return -1
        if (x<12)
            return 0
        if (x<14)
            return 1
        if (x<16)
            return 2
        if (x<18)
            return 3
        if (x<20)
            return 4
        if (x<22)
            return 5
        if (x<24)
            return 6
        if (x<26)
            return 7
        if (x<28)
            return 8
        if (x<30)
            return 9
        if (x==30)
            return 10
        else
            return 0
    }

}