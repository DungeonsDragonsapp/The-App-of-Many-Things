package com.example.theappofmanythings

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "ArticleAdapter"

class SpellAdapter(private val context: Context, private val listSpells: List<listSpell>) :
    RecyclerView.Adapter<SpellAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = listSpells[position]
        holder.bind(article)
    }

    override fun getItemCount() = listSpells.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
        private val abstractTextView = itemView.findViewById<TextView>(R.id.descriptionLine)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(article: listSpell) {
            titleTextView.text = article.name
            abstractTextView.text = article.url
        }

        override fun onClick(v: View?) {
            // TODO: Get selected article
            val spell = listSpells[layoutPosition]

            // TODO: Navigate to Details screen and pass selected article
            val intent = Intent(context, IndivSpellActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, spell)
            context.startActivity(intent)
        }


    }


}