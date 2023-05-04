package com.example.theappofmanythings

import android.R
import android.R.attr.bitmap
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseFile
import com.parse.ParseUser
import java.io.ByteArrayOutputStream
import java.io.IOException


//public val character : ParseObject = ParseObject("character")
var character = Character()

class CharacterCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.theappofmanythings.R.layout.character_creation)

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_PHOTO_CODE)


        val spinnerRaces = findViewById<Spinner>(com.example.theappofmanythings.R.id.spinner_races)
        val spinnerClasses =
            findViewById<Spinner>(com.example.theappofmanythings.R.id.spinner_classes)
        val adapter =
            ArrayAdapter.createFromResource(
                this,
                com.example.theappofmanythings.R.array.races,
                R.layout.simple_spinner_item
            )
        adapter.setDropDownViewResource(R.layout.simple_spinner_item)

        val adapterTwo =
            ArrayAdapter.createFromResource(
                this,
                com.example.theappofmanythings.R.array.classes,
                R.layout.simple_spinner_item
            )
        adapterTwo.setDropDownViewResource(R.layout.simple_spinner_item)

        spinnerRaces.adapter = adapter
        spinnerClasses.adapter = adapterTwo


        val nextButton = findViewById<Button>(com.example.theappofmanythings.R.id.nextButton)
        val backgroundEditText =
            findViewById<EditText>(com.example.theappofmanythings.R.id.backgroundInput)
        val levelEditText = findViewById<EditText>(com.example.theappofmanythings.R.id.levelInput)
        val nameEditText = findViewById<EditText>(com.example.theappofmanythings.R.id.characterNameInput)
        nextButton.setOnClickListener {
            //val character = ParseObject("character")
            val myRace = spinnerRaces.selectedItem.toString()
            val myClass = spinnerClasses.selectedItem.toString()
            val myBackground = backgroundEditText.text.toString()
            val myName = nameEditText.text.toString()
            var myLevel = levelEditText.text.toString().toInt()
            var charactercreate = Character()
            charactercreate.setName(myName)
            charactercreate.setRace(myRace)
            charactercreate.setClass(myClass)
            charactercreate.setBackground(myBackground)
            charactercreate.setLevel(myLevel)
            charactercreate.setUser(ParseUser.getCurrentUser())

            charactercreate.saveInBackground { exception ->
                if (exception != null) {
                    Log.d(TAG, "Error while adding car")
                    exception.printStackTrace()
                    Toast.makeText(this, "Failed to add car", Toast.LENGTH_SHORT).show()
                } else {
                    Log.i(TAG, "Successfully added car to parse!")
                }
            }

            character=charactercreate
            val intent = Intent(this@CharacterCreationActivity, StatActivity::class.java)
            startActivity(intent)
        }

    }
    companion object
    {
        const val TAG = "CharacterCreationActivity"

    }

    val PICK_PHOTO_CODE = 1046

    // Trigger gallery selection for a photo
    fun onPickPhoto(view: View?) {
        // Create intent for picking a photo from the gallery
        val intent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
        // So as long as the result is not null, it's safe to use the intent.
        if (intent.resolveActivity(packageManager) != null) {
            // Bring up gallery to select a photo
            startActivityForResult(intent, PICK_PHOTO_CODE)
        }
    }

    public fun loadFromUri(photoUri: Uri): Bitmap? {
        var image: Bitmap? = null
        try {
            // check version of Android on device
            image = if (Build.VERSION.SDK_INT > 27) {
                // on newer versions of Android, use the new decodeBitmap method
                val source: ImageDecoder.Source =
                    ImageDecoder.createSource(this.contentResolver, photoUri)
                ImageDecoder.decodeBitmap(source)
            } else {
                // support older versions of Android by using getBitmap
                MediaStore.Images.Media.getBitmap(this.contentResolver, photoUri)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && requestCode == PICK_PHOTO_CODE) {
            val photoUri = data.data

            // Load the image located at photoUri into selectedImage
            val selectedImage = photoUri?.let { loadFromUri(it) }

            //val stream = ByteArrayOutputStream()
            //val bitmapBytes: ByteArray = stream.toByteArray()
            //val image = ParseFile("myImage", selectedImage)
            //character.setImage(photoUri)

            // Load the selected image into a preview
            val ivPreview: ImageView = findViewById<View>(com.example.theappofmanythings.R.id.imageView) as ImageView
            ivPreview.setImageBitmap(selectedImage)
        }
    }
}
