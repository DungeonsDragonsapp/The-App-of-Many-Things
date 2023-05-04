package com.example.theappofmanythings

import android.R
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.theappofmanythings.R.*
import java.io.IOException


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

    // PICK_PHOTO_CODE is a constant integer
    val PICK_PHOTO_CODE = 1046

    // Trigger gallery selection for a photo


    private fun prepareCharacterRV() {
        //TODO get RV prepared
    }

    private fun getDataFromServer() {
        //TODO get characters from server
    }




}