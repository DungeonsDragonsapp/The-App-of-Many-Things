package com.example.theappofmanythings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class languageActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.language_setter)
        val confirmButton = findViewById<Button>(R.id.button)


        confirmButton.setOnClickListener {
            val languages = findViewById<EditText>(com.example.theappofmanythings.R.id.languages).text.toString()

            val proficiencies = findViewById<EditText>(com.example.theappofmanythings.R.id.proficiencies).text.toString()

            character.setLanguages(languages)
            character.setProficiencies(proficiencies)
            character.saveInBackground()

            val intent = Intent(this@languageActivity, CharacterMainActivity::class.java)
            startActivity(intent)
        }
    }
}