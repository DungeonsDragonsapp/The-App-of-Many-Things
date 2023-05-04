package com.example.theappofmanythings

import android.util.Log
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
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theappofmanythings.R.*
import com.example.theappofmanythings.databinding.ActivityMainBinding
import com.parse.*
import java.io.IOException


class CharacterList : AppCompatActivity()  {
    private val listCharacter = mutableListOf<listChar>()
    private lateinit var articlesRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)




        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId("0zcJHdAztC4AZk32EkESzeRT5gr7e2KbXE6Fs55R")
                .clientKey("SJAw8w4lQONYEvt7HYmyx6KwGybv1qoUAA8AC5sg")
                .server("https://parseapi.back4app.com/")
                .build())

        // Register the Car Parse model so that we can use that class and link to the table
        ParseObject.registerSubclass(Character::class.java)


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(view)
        setContentView(layout.character_list)

        articlesRecyclerView = findViewById(id.characterList)

        // TODO: Set up ArticleAdapter with articles
        val charAdapter = CharacterListAdapter(this, listCharacter)
        articlesRecyclerView.adapter = charAdapter


        articlesRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            articlesRecyclerView.addItemDecoration(dividerItemDecoration)
        }


        


        queryFromDb()
        charAdapter.notifyDataSetChanged()

        val createChar = findViewById<View>(id.createCharacterButton) as Button
        createChar.setOnClickListener {
            val intent = Intent(this@CharacterList, CharacterCreationActivity::class.java)
            startActivity(intent)
        }

        // PICK_PHOTO_CODE is a constant integer
        val PICK_PHOTO_CODE = 1046

        // Trigger gallery selection for a photo

    }

    private fun queryFromDb() {
        // Start creating a Parse query
        val query: ParseQuery<Character> = ParseQuery(Character::class.java)
    


    

        // Asking parse to also include the user that posted the Post (Since User is a pointer in the Post table)
        query.include(Character.KEY_USER)

        // Get cars in reverse-chronological order that we created them
        query.addDescendingOrder("createdAt")

        // Only retrieving the cars of the currently authenticated user
        query.whereEqualTo("User", ParseUser.getCurrentUser())

        // Launch the query
        query.findInBackground { itemsResponse, e ->
            if (e != null) {
                Log.e("TAG", "Error fetching posts")
            } else {
                if (itemsResponse != null) {
                    val dbCharList = mutableListOf<listChar>()

                    for (char in itemsResponse) {
                        /*
                        Log.i(
                            "TAG",
                            "Character: " + char.getName() + ", username: " + char.getUser()?.username
                        )
                        */
                        Log.i("CHAR", "" + char.getName())
                        val addToDb = listChar("IsDb", char.getName(), char.objectId,
                            char.getRace(),
                            char.getClass(),
                            char.getLevel(),
                            //char.getImage(),
                            char.getBackground(),
                            char.getStrength(),
                            char.getDex(),
                            char.getConst(),
                            char.getIntelligence(),
                            char.getWis(),
                            char.getCharisma(),
                            char.getPersonality(),
                            char.getBonds(),
                            char.getFlaws(),
                            char.getIdeals(),
                        )
                        dbCharList.add(addToDb)
                    }
                    listCharacter.addAll(dbCharList)
                    //articleAdapter.notifyDataSetChanged()
                    //swipeContainer.isRefreshing = false
                }
            }
        }
    }




}