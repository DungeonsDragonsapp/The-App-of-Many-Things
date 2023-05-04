package com.example.theappofmanythings

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class basicTraitsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.basic_traits_page)

        val traits = findViewById<TextView>(com.example.theappofmanythings.R.id.traitsReplace)
        val ideals = findViewById<TextView>(com.example.theappofmanythings.R.id.idealsReplace)
        val bonds = findViewById<TextView>(com.example.theappofmanythings.R.id.bondsReplace)
        val flaws = findViewById<TextView>(com.example.theappofmanythings.R.id.flawsReplace)

        traits.text = character.getName().toString()
        ideals.text = character.getRace().toString()
        bonds.text = character.getClass().toString()
        flaws.text = character.getBackground().toString()
    }
}