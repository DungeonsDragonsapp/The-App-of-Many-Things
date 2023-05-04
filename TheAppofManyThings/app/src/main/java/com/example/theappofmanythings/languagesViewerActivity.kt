package com.example.theappofmanythings

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class languagesViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.language_page)

        val languages = findViewById<TextView>(com.example.theappofmanythings.R.id.languagesReplace)
        val proficiencies = findViewById<TextView>(com.example.theappofmanythings.R.id.proficienciesReplace)

        languages.text = character.getLanguages().toString()
        proficiencies.text = character.getProficiencies().toString()
    }
}