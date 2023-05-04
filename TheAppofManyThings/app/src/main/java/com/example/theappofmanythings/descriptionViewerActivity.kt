package com.example.theappofmanythings

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class descriptionViewerActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.description_viewer)

        val traits = findViewById<TextView>(com.example.theappofmanythings.R.id.traitsReplace)
        val ideals = findViewById<TextView>(com.example.theappofmanythings.R.id.idealsReplace)
        val bonds = findViewById<TextView>(com.example.theappofmanythings.R.id.bondsReplace)
        val flaws = findViewById<TextView>(com.example.theappofmanythings.R.id.flawsReplace)

        traits.text = character.getPersonality().toString()
        ideals.text = character.getIdeals().toString()
        bonds.text = character.getBonds().toString()
        flaws.text = character.getFlaws().toString()
    }
}