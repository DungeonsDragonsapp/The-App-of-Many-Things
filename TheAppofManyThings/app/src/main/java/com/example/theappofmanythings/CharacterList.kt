package com.example.theappofmanythings

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.theappofmanythings.R.*
import com.parse.FindCallback
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser


class CharacterList : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.character_list)

        val createChar = findViewById<View>(id.createCharacterButton) as Button
        createChar.setOnClickListener {
            val intent = Intent(this@CharacterList, CharacterCreationActivity::class.java)
            startActivity(intent)
        }

        val characterArrayList = ArrayList<Character>()

        prepareCharacterRV()

        getDataFromServer()
    }

    private fun prepareCharacterRV() {
        //TODO get RV prepared
    }

    private fun getDataFromServer() {
        //TODO get characters from server
    }




}