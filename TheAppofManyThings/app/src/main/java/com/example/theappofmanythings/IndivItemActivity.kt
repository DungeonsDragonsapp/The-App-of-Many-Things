package com.example.theappofmanythings

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import com.parse.*
import org.json.JSONException
import kotlin.math.abs

private const val TAG = "DetailActivity"

class IndivItemActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView
    private lateinit var secondTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        //mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        bylineTextView = findViewById(R.id.firstLine)
        secondTextView = findViewById(R.id.secondaryLine)
        abstractTextView = findViewById(R.id.descriptionLine)

        // TODO: Get the extra from the Intent
        val listEquip = intent.getSerializableExtra(ARTICLE_EXTRA) as listEquip

        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = listEquip.name

        //call a new API call
        if(listEquip.index == "IsDb")
        {
            val query: ParseQuery<Item> = ParseQuery(Item::class.java)

            // Asking parse to also include the user that posted the Post (Since User is a pointer in the Post table)
            query.include(Item.KEY_USER)

            // Only retrieving the cars of the currently authenticated user
            query.whereEqualTo("objectId", listEquip.url)

            // Launch the query
            query.findInBackground(object : FindCallback<Item> {
                override fun done(carsResponse: MutableList<Item>?, e: ParseException?) {
                    if (e != null) {
                        Log.e(TAG, "Error fetching posts")
                    } else {
                        if (carsResponse != null) {
                            for (singleCar in carsResponse) {
                                Log.i(
                                    TAG,
                                    "Car: " + singleCar.getName() + ", username: " + singleCar.getUser()?.username
                                )
                            }
                            bylineTextView.text = "Item worth: "+carsResponse[0].getQuantity()+" "+carsResponse[0].getUnit()
                            secondTextView.text = carsResponse[0].getCategory()
                            abstractTextView.text = carsResponse[0].getDescription()
                        }
                    }
                }
            })
        }
        else
        {
            val client = AsyncHttpClient()
            client.get("https://www.dnd5eapi.co${listEquip.url}", object : JsonHttpResponseHandler() {
                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    response: String?,
                    throwable: Throwable?
                ) {
                    Log.e(TAG, "Failed to fetch an individual item: $statusCode")
                }

                override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                    Log.i(TAG, "Successfully fetched an individual item: $json")
                    try {

                        val parsedJson = createJson().decodeFromString(
                            CoolerItem.serializer(),
                            json.jsonObject.toString())

                        secondTextView.text = "Item worth: "+parsedJson.cost?.quantity+" "+parsedJson.cost?.unit
                        bylineTextView.text = parsedJson.equipment_category?.name
                        if(parsedJson.desc.isNotEmpty())
                            abstractTextView.text = parsedJson.desc?.get(0);



                    } catch (e: JSONException) {
                        Log.e(TAG, "Exception: $e")
                    }
                }

            })
        }



        bylineTextView.text = "Hello world!"
        abstractTextView.text = listEquip.url

        // TODO: Load the media image
    }
}