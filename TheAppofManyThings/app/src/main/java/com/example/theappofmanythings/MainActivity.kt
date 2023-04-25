package com.example.theappofmanythings

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theappofmanythings.databinding.ActivityMainBinding
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.parse.*
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException

fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private const val TAG = "MainActivity/"
private const val ARTICLE_SEARCH_URL =
    "https://www.dnd5eapi.co/api/spells"

class MainActivity : AppCompatActivity() {
    private val listSpells = mutableListOf<listSpell>()
    private lateinit var articlesRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build())

        // Register the Car Parse model so that we can use that class and link to the table
        ParseObject.registerSubclass(Spell::class.java)


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        articlesRecyclerView = findViewById(R.id.articles)

        // TODO: Set up ArticleAdapter with articles
        val articleAdapter = ArticleAdapter(this, listSpells)
        articlesRecyclerView.adapter = articleAdapter


        articlesRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            articlesRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        val client = AsyncHttpClient()
        client.get(ARTICLE_SEARCH_URL, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to fetch spells: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "Successfully fetched spells: $json")
                try {
                    // TODO: Create the parsedJSON
                    val parsedJson = createJson().decodeFromString(
                        SearchNewsResponse.serializer(),
                        json.jsonObject.toString()
                    )

                    // TODO: Do something with the returned json (contains article information)

                    // TODO: Save the articles and reload the screen
                    parsedJson.results?.let { list ->
                        listSpells.addAll(list)

                        // Reload the screen
                        articleAdapter.notifyDataSetChanged()
                    }

                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e")
                }
            }

        })

        queryFromDb()
        articleAdapter.notifyDataSetChanged()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{

            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)

            //val intent = Intent(this, AddActivity::class.java)
            //startActivity(intent)
        }

    }

    private fun queryFromDb() {
        // Start creating a Parse query
        val query: ParseQuery<Spell> = ParseQuery(Spell::class.java)

        // Asking parse to also include the user that posted the Post (Since User is a pointer in the Post table)
        query.include(Spell.KEY_USER)

        // Get cars in reverse-chronological order that we created them
        query.addDescendingOrder("createdAt")

        // Only retrieving the cars of the currently authenticated user
        query.whereEqualTo("user", ParseUser.getCurrentUser())

        // Launch the query
        query.findInBackground(object : FindCallback<Spell> {
            override fun done(spellsResponse: MutableList<Spell>?, e: ParseException?) {
                if (e != null) {
                    Log.e(TAG, "Error fetching posts")
                } else {
                    if (spellsResponse != null) {
                        val dbSpellList = mutableListOf<listSpell>()

                        for (singleCar in spellsResponse)
                        {
                            Log.i(
                                TAG,
                                "Spell: " + singleCar.getName() + ", username: " + singleCar.getUser()?.username
                            )
                            val addToDb = listSpell("IsDb", singleCar.getName(), singleCar.objectId)
                            dbSpellList.add(addToDb)
                        }
                        listSpells.addAll(dbSpellList)
                        //articleAdapter.notifyDataSetChanged()
                        //swipeContainer.isRefreshing = false
                    }
                }
            }
        })
    }
}