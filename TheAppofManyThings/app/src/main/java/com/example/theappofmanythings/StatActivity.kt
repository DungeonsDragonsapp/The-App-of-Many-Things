package com.example.theappofmanythings

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
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

        val strengthString = strength.text.toString()
        val dexString = dexterity.text.toString()
        val constString = constitution.text.toString()
        val intString = intelligence.text.toString()
        val wisString = wisdom.text.toString()
        val charismaString = charisma.text.toString()
        nextButton.setOnClickListener {
            character.put("Strength", strengthString)
            character.put("Dexterity", dexString)
            character.put("Constitution", constString)
            character.put("Intelligence", intString)
            character.put("Wisdom", wisString)
            character.put("Charisma", charismaString)
        }
    }
}