package com.example.theappofmanythings

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseObject

public val character : ParseObject = ParseObject("character")

class CharacterCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.character_creation)
        val spinnerRaces = findViewById<Spinner>(com.example.theappofmanythings.R.id.spinner_races)
        val spinnerClasses = findViewById<Spinner>(com.example.theappofmanythings.R.id.spinner_classes)
        val adapter =
            ArrayAdapter.createFromResource(this, com.example.theappofmanythings.R.array.races, R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(R.layout.simple_spinner_item)

        val adapterTwo =
            ArrayAdapter.createFromResource(this, com.example.theappofmanythings.R.array.classes, R.layout.simple_spinner_item)
        adapterTwo.setDropDownViewResource(R.layout.simple_spinner_item)

        spinnerRaces.adapter = adapter
        spinnerClasses.adapter = adapterTwo



        val nextButton = findViewById<Button>(com.example.theappofmanythings.R.id.nextButton)
        val backgroundEditText = findViewById<EditText>(com.example.theappofmanythings.R.id.backgroundInput)
        val levelEditText = findViewById<EditText>(com.example.theappofmanythings.R.id.levelInput)
        nextButton.setOnClickListener {
            //val character = ParseObject("character")
            val myRace = spinnerRaces.selectedItem.toString()
            val myClass = spinnerClasses.selectedItem.toString()
            val myBackground = backgroundEditText.text.toString()
            val myLevel = levelEditText.text.toString()
            character.put("race", myRace)
            character.put("class", myClass)
            character.put("background", myBackground)
            character.put("level", myLevel)
            character.saveInBackground()


            val intent = Intent(this@CharacterCreationActivity, StatActivity::class.java)
            startActivity(intent)
        }


    }
}
