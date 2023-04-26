package com.example.theappofmanythings

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseObject
import com.parse.ParseUser


//public val character : ParseObject = ParseObject("character")
var character = Character()

class CharacterCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.character_creation)
        val spinnerRaces = findViewById<Spinner>(com.example.theappofmanythings.R.id.spinner_races)
        val spinnerClasses =
            findViewById<Spinner>(com.example.theappofmanythings.R.id.spinner_classes)
        val adapter =
            ArrayAdapter.createFromResource(
                this,
                com.example.theappofmanythings.R.array.races,
                R.layout.simple_spinner_item
            )
        adapter.setDropDownViewResource(R.layout.simple_spinner_item)

        val adapterTwo =
            ArrayAdapter.createFromResource(
                this,
                com.example.theappofmanythings.R.array.classes,
                R.layout.simple_spinner_item
            )
        adapterTwo.setDropDownViewResource(R.layout.simple_spinner_item)

        spinnerRaces.adapter = adapter
        spinnerClasses.adapter = adapterTwo


        val nextButton = findViewById<Button>(com.example.theappofmanythings.R.id.nextButton)
        val backgroundEditText =
            findViewById<EditText>(com.example.theappofmanythings.R.id.backgroundInput)
        val levelEditText = findViewById<EditText>(com.example.theappofmanythings.R.id.levelInput)
        val nameEditText = findViewById<EditText>(com.example.theappofmanythings.R.id.characterNameInput)
        nextButton.setOnClickListener {
            //val character = ParseObject("character")
            val myRace = spinnerRaces.selectedItem.toString()
            val myClass = spinnerClasses.selectedItem.toString()
            val myBackground = backgroundEditText.text.toString()
            val myName = nameEditText.text.toString()
            var myLevel = levelEditText.text.toString().toInt()
            var charactercreate = Character()
            charactercreate.setName(myName)
            charactercreate.setRace(myRace)
            charactercreate.setClass(myClass)
            charactercreate.setBackground(myBackground)
            charactercreate.setLevel(myLevel)
            charactercreate.setUser(ParseUser.getCurrentUser())

            charactercreate.saveInBackground { exception ->
                if (exception != null) {
                    Log.d(TAG, "Error while adding car")
                    exception.printStackTrace()
                    Toast.makeText(this, "Failed to add car", Toast.LENGTH_SHORT).show()
                } else {
                    Log.i(TAG, "Successfully added car to parse!")
                }
            }

            character=charactercreate
            val intent = Intent(this@CharacterCreationActivity, StatActivity::class.java)
            startActivity(intent)
        }

    }
    companion object
    {
        const val TAG = "CharacterCreationActivity"

    }
}
