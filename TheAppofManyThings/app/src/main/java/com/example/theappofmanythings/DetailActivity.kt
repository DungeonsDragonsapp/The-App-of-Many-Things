package com.codepath.articlesearch

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONException
import org.json.JSONObject

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
        val spell = intent.getSerializableExtra(ARTICLE_EXTRA) as Spell

        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = spell.name

        //call a new API call

        val client = AsyncHttpClient()
        client.get("https://www.dnd5eapi.co${spell.url}", object : JsonHttpResponseHandler() {
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
                try {/*
                    // TODO: Create the parsedJSON
                    val parsedJson = createJson().decodeFromString(
                        SearchNewsResponse.serializer(),
                        json.jsonObject.toString()
                    )

                    // TODO: Do something with the returned json (contains article information)

                    // TODO: Save the articles and reload the screen
                    parsedJson.results?.let { list ->
                        spells.addAll(list)

                        // Reload the screen
                        articleAdapter.notifyDataSetChanged()
                    }*/
                    val parsedJson = createJson().decodeFromString(
                        CoolerSpell.serializer(),
                        json.jsonObject.toString()
                    )

                    bylineTextView.text = "Spell level: "+parsedJson.level.toString()
                    abstractTextView.text = parsedJson.desc?.get(0);


                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e")
                }
            }

        })


        bylineTextView.text = "Hello world!"
        abstractTextView.text = spell.url

        // TODO: Load the media image
    }
}