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

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_PHOTO_CODE)

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

    fun loadFromUri(photoUri: Uri?): Bitmap? {
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
        if (data != null && requestCode == PICK_PHOTO_CODE) {
            val photoUri = data.data

            // Load the image located at photoUri into selectedImage
            val selectedImage = loadFromUri(photoUri)

            // Load the selected image into a preview
            val ivPreview: ImageView = findViewById<View>(R.id.ivPreview) as ImageView
            ivPreview.setImageBitmap(selectedImage)
        }
    }

    private fun prepareCharacterRV() {
        //TODO get RV prepared
    }

    private fun getDataFromServer() {
        //TODO get characters from server
    }




}