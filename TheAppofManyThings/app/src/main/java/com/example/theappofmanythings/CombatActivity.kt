package com.example.theappofmanythings

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CombatActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.combat_page)


        val speed = findViewById<TextView>(com.example.theappofmanythings.R.id.speedReplace)


    }
}