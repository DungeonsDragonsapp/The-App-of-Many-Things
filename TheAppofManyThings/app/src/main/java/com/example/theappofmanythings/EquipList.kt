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
import okhttp3.Headers
import org.json.JSONException


private const val TAG = "EquipList/"
private const val ARTICLE_SEARCH_URL =
    "https://www.dnd5eapi.co/api/equipment"

class EquipList : AppCompatActivity() {
    private val listEquip = mutableListOf<listEquip>()
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
        ParseObject.registerSubclass(Item::class.java)


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(view)
        setContentView(R.layout.equipment_list)

        articlesRecyclerView = findViewById(R.id.articles)

        // TODO: Set up ArticleAdapter with articles
        val itemAdapter = ItemAdapter(this, listEquip)
        articlesRecyclerView.adapter = itemAdapter


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
                Log.e(TAG, "Failed to fetch items: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "Successfully fetched items: $json")
                try {
                    // TODO: Create the parsedJSON
                    val parsedJson = createJson().decodeFromString(
                        InitItemResp.serializer(),
                        json.jsonObject.toString()
                    )

                    // TODO: Do something with the returned json (contains article information)

                    // TODO: Save the articles and reload the screen
                    parsedJson.results?.let { list ->
                        listEquip.addAll(list)

                        // Reload the screen
                        itemAdapter.notifyDataSetChanged()
                    }

                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e")
                }
            }

        })

        queryFromDb()
        itemAdapter.notifyDataSetChanged()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{

            val intent = Intent(this@EquipList, AddItemActivity::class.java)
            startActivity(intent)

        }


    }

    private fun queryFromDb() {
        // Start creating a Parse query
        val query: ParseQuery<Item> = ParseQuery(Item::class.java)

        // Asking parse to also include the user that posted the Post (Since User is a pointer in the Post table)
        query.include(Item.KEY_USER)

        // Get cars in reverse-chronological order that we created them
        query.addDescendingOrder("createdAt")

        // Only retrieving the cars of the currently authenticated user
        query.whereEqualTo("user", ParseUser.getCurrentUser())

        // Launch the query
        query.findInBackground(object : FindCallback<Item> {
            override fun done(itemsResponse: MutableList<Item>?, e: ParseException?) {
                if (e != null) {
                    Log.e(TAG, "Error fetching posts")
                } else {
                    if (itemsResponse != null) {
                        val dbItemList = mutableListOf<listEquip>()

                        for (singleCar in itemsResponse)
                        {
                            Log.i(
                                TAG,
                                "Item: " + singleCar.getName() + ", username: " + singleCar.getUser()?.username
                            )
                            val addToDb = listEquip("IsDb", singleCar.getName(), singleCar.objectId)
                            dbItemList.add(addToDb)
                        }
                        listEquip.addAll(dbItemList)
                        //articleAdapter.notifyDataSetChanged()
                        //swipeContainer.isRefreshing = false
                    }
                }
            }
        })
    }
}