package com.example.theappofmanythings

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CharacterListAdapter(private val context: Context, CharacterArrayList: ArrayList<Character>) :
    RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {
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
}