package com.example.theappofmanythings

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser
import okhttp3.Headers
import org.json.JSONException

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        //mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        bylineTextView = findViewById(R.id.mediaByline)
        abstractTextView = findViewById(R.id.mediaAbstract)

        // TODO: Get the extra from the Intent
        val listSpell = intent.getSerializableExtra(ARTICLE_EXTRA) as listSpell

        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = listSpell.name

        //call a new API call
        if(listSpell.index == "IsDb")
        {
            val query: ParseQuery<Spell> = ParseQuery(Spell::class.java)

            // Asking parse to also include the user that posted the Post (Since User is a pointer in the Post table)
            query.include(Spell.KEY_USER)

            // Only retrieving the cars of the currently authenticated user
            query.whereEqualTo("objectId", listSpell.url)

            // Launch the query
            query.findInBackground(object : FindCallback<Spell> {
                override fun done(carsResponse: MutableList<Spell>?, e: ParseException?) {
                    if (e != null) {
                        Log.e(TAG, "Error fetching posts")
                    } else {
                        if (carsResponse != null) {
                            for (singleCar in carsResponse) {
                                Log.i(
                                    TAG,
                                    "Car: " + singleCar.getLevel() + ", username: " + singleCar.getUser()?.username
                                )
                            }
                            bylineTextView.text = "Spell level: "+carsResponse[0].getLevel()
                            abstractTextView.text = carsResponse[0].getDescription()
                        }
                    }
                }
            })
        }
        else
        {
            val client = AsyncHttpClient()
            client.get("https://www.dnd5eapi.co${listSpell.url}", object : JsonHttpResponseHandler() {
                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    response: String?,
                    throwable: Throwable?
                ) {
                    Log.e(TAG, "Failed to fetch an individual spell: $statusCode")
                }

                override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                    Log.i(TAG, "Successfully fetched an individual spell: $json")
                    try {

                        val parsedJson = createJson().decodeFromString(
                            CoolerSpell.serializer(),
                            json.jsonObject.toString())

                        bylineTextView.text = "Spell level: "+parsedJson.level.toString()
                        abstractTextView.text = parsedJson.desc?.get(0);


                    } catch (e: JSONException) {
                        Log.e(TAG, "Exception: $e")
                    }
                }

            })
        }



        bylineTextView.text = "Hello world!"
        abstractTextView.text = listSpell.url

        // TODO: Load the media image
    }
}