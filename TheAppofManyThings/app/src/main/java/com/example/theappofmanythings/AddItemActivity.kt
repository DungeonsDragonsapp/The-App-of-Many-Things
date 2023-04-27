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

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_input_layout)

        val button = findViewById<Button>(R.id.submitButton)
        val etDesc = findViewById<EditText>(R.id.editTextDesc)
        val etVal = findViewById<EditText>(R.id.editTextVal)
        val etName = findViewById<EditText>(R.id.editTextName)
        val etCat = findViewById<EditText>(R.id.editTextCategory)

        button.setOnClickListener{

            val desc = etDesc.getText().toString()
            val value = etVal.getText().toString()
            val name = etName.getText().toString()
            val cat = etCat.getText().toString()

            if(desc == "")
            {
                Toast.makeText(
                    this, "Please input a valid description the item", Toast.LENGTH_SHORT).show()
            }
            else if(value == "")
            {
                Toast.makeText(
                    this, "Please input a valid worth for the item", Toast.LENGTH_SHORT).show()
            }
            else if(name == "")
            {
                Toast.makeText(
                    this, "Please input a valid name for the item", Toast.LENGTH_SHORT).show()
            }
            else if(cat == "")
            {
                Toast.makeText(
                    this, "Please input a valid category for the item", Toast.LENGTH_SHORT).show()
            }
            else {

                val item = Item()
                item.setName(name)
                item.setDescription(desc)
                item.setCategory(cat)
                item.setQuantity(value.toInt())
                item.setUnit("gp")
                item.setUser(ParseUser.getCurrentUser()) // Get currently logged in user and set as owner of car

                // Save car to parse backend
                item.saveInBackground{ exception ->
                    if (exception != null) {
                        Log.d(TAG, "Error while adding item")
                        exception.printStackTrace()
                        Toast.makeText(this, "Failed to add item", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.i(TAG, "Successfully added item to parse!")
                    }
                }

                goToItemList()

            }

        }

    }

    private fun goToItemList() {
        val intent = Intent(this@AddItemActivity, EquipList::class.java)
        startActivity(intent)
        finish()
    }


}