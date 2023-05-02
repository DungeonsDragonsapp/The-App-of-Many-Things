package com.example.theappofmanythings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CharacterMainActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.character_mainpage)

        val statButton = findViewById<Button>(com.example.theappofmanythings.R.id.statButton)
        val combatButton = findViewById<Button>(com.example.theappofmanythings.R.id.combatButton)
        val equipButton = findViewById<Button>(com.example.theappofmanythings.R.id.equipButton)
        val spellButton = findViewById<Button>(com.example.theappofmanythings.R.id.spellButton)

        statButton.setOnClickListener {
            val intent = Intent(this@CharacterMainActivity, statChangeActivity::class.java)
            startActivity(intent)
        }

        combatButton.setOnClickListener {
            val intent = Intent(this@CharacterMainActivity, CombatActivity::class.java)
            startActivity(intent)
        }

        equipButton.setOnClickListener {
            val intent = Intent(this@CharacterMainActivity, EquipList::class.java)
            startActivity(intent)
        }

        spellButton.setOnClickListener {
            val intent = Intent(this@CharacterMainActivity, MainActivity::class.java)
            startActivity(intent)
        }




    }
}