package com.example.theappofmanythings

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


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
    }
}
