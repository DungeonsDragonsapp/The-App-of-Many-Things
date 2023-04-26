package com.example.theappofmanythings

import android.R
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseObject


class StatActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.stat_creation)


        val nextButton = findViewById<Button>(com.example.theappofmanythings.R.id.nextButton2)
        val strength = findViewById<EditText>(com.example.theappofmanythings.R.id.strengthInput)
        val dexterity = findViewById<EditText>(com.example.theappofmanythings.R.id.dexInput)
        val constitution = findViewById<EditText>(com.example.theappofmanythings.R.id.constInput)
        val intelligence = findViewById<EditText>(com.example.theappofmanythings.R.id.intInput)
        val wisdom = findViewById<EditText>(com.example.theappofmanythings.R.id.wisInput)
        val charisma = findViewById<EditText>(com.example.theappofmanythings.R.id.charismaInput)


        nextButton.setOnClickListener {
            val strengthString = strength.text.toString().toInt()
            val dexString = dexterity.text.toString().toInt()
            val constString = constitution.text.toString().toInt()
            val intString = intelligence.text.toString().toInt()
            val wisString = wisdom.text.toString().toInt()
            val charismaString = charisma.text.toString().toInt()

            character.setStrength(strengthString)
            character.setDex(dexString)
            character.setConst(constString)
            character.setIntelligence(intString)
            character.setWis(wisString)
            character.setCharisma(charismaString)
            character.saveInBackground()
        }
    }
}