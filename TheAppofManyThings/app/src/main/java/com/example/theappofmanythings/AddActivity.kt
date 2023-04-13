package com.example.theappofmanythings


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.codepath.articlesearch.ItemApplication

private const val TAG = "DetailActivity"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_layout)

        val button = findViewById<Button>(R.id.submitButton)
        val etLink = findViewById<EditText>(R.id.editTextDesc)
        val etMoney = findViewById<EditText>(R.id.editTextLvl)
        val etName = findViewById<EditText>(R.id.editTextName)

        button.setOnClickListener{

            val link = etLink.getText().toString()
            val money = etMoney.getText().toString()
            val thisName = etName.getText().toString()

            if(link == "")
            {
                Toast.makeText(
                    this, "Please input a valid amount of protein for the food", Toast.LENGTH_SHORT).show()
            }
            else if(money == "")
            {
                Toast.makeText(
                    this, "Please input a valid amount of calories for the food", Toast.LENGTH_SHORT).show()
            }
            else if(thisName == "")
            {
                Toast.makeText(
                    this, "Please input a valid name for the food", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(
                    this, "Shit's been made!", Toast.LENGTH_SHORT).show()

                super.finish()

            }

        }

    }


}