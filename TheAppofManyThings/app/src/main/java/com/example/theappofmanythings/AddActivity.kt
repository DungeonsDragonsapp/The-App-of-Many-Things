package com.example.theappofmanythings


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseUser

//import com.codepath.articlesearch.ItemApplication

private const val TAG = "DetailActivity"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_layout)

        val button = findViewById<Button>(R.id.submitButton)
        val etDesc = findViewById<EditText>(R.id.editTextDesc)
        val etLvl = findViewById<EditText>(R.id.editTextLvl)
        val etName = findViewById<EditText>(R.id.editTextName)

        button.setOnClickListener{

            val desc = etDesc.getText().toString()
            val lvl = etLvl.getText().toString()
            val name = etName.getText().toString()

            if(desc == "")
            {
                Toast.makeText(
                    this, "Please input a valid description the spell", Toast.LENGTH_SHORT).show()
            }
            else if(lvl == "")
            {
                Toast.makeText(
                    this, "Please input a valid level for the spell", Toast.LENGTH_SHORT).show()
            }
            else if(name == "")
            {
                Toast.makeText(
                    this, "Please input a valid name for the spell", Toast.LENGTH_SHORT).show()
            }
            else {

                //val newItem = Item(name, money, link)

                /*lifecycleScope.launch(Dispatchers.IO)
                {
                    (application as ItemApplication).db.itemDao().insertAll(
                        ItemEntity(
                            name = thisName,
                            price = money,
                            url = link,
                        )
                    )
                }*/

// Create car object and update it's attributes
                val spell = Spell()
                spell.setName(name)
                spell.setDescription(desc)
                spell.setLevel(lvl)
                spell.setUser(ParseUser.getCurrentUser()) // Get currently logged in user and set as owner of car

                // Save car to parse backend
                spell.saveInBackground{ exception ->
                    if (exception != null) {
                        Log.d(TAG, "Error while adding spell")
                        exception.printStackTrace()
                        Toast.makeText(this, "Failed to add spell", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.i(TAG, "Successfully added spell to parse!")
                    }
                }

                goToMainActivity()

            }

        }

    }

    private fun goToMainActivity() {
        val intent = Intent(this@AddActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}