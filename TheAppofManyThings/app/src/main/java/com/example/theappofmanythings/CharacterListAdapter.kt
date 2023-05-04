package com.example.theappofmanythings

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CharacterListAdapter(private val context: Context, private val characterArrayList: List<listChar>) :
    RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {
    /*
    private val characterArrayList: ArrayList<Character>

    // creating a constructor class.
    init {
        this.characterArrayList = CharacterArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // passing our layout file for displaying our card item
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.character_in_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // setting data to our text views from our modal class.
        val characters: Character = characterArrayList[position]
        holder.charNameText.text = characters.getName()

    }

    override fun getItemCount(): Int {
        return characterArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // creating variables for our text views.
        val charNameText: TextView


        init {
            // initializing our text views.
            charNameText = itemView.findViewById(R.id.characterNameInList)

        }
    }
    */

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.character_in_list, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val article = characterArrayList[position]
            holder.bind(article)
        }

        override fun getItemCount() = characterArrayList.size

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
            View.OnClickListener {

            private val titleTextView = itemView.findViewById<TextView>(R.id.characterNameInList)
            //private val abstractTextView = itemView.findViewById<TextView>(R.id.descriptionLine)

            init {
                itemView.setOnClickListener(this)
            }

            // TODO: Write a helper method to help set up the onBindViewHolder method
            fun bind(article: listChar) {
                titleTextView.text = article.name
                //abstractTextView.text = article.url
            }

            override fun onClick(v: View?) {
                // TODO: Get selected article
                val item = characterArrayList[layoutPosition]

                // TODO: Navigate to Details screen and pass selected article
                val intent = Intent(context, CharacterMainActivity::class.java)
                intent.putExtra(ARTICLE_EXTRA, item)
                context.startActivity(intent)
            }


        }


    }
