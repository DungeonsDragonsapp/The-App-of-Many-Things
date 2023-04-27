package com.example.theappofmanythings

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

const val ITEM_EXTRA = "ITEM_EXTRA"
private const val TAG = "ArticleAdapter"

class ItemAdapter(private val context: Context, private val listEquip: List<listEquip>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = listEquip[position]
        holder.bind(article)
    }

    override fun getItemCount() = listEquip.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
        private val abstractTextView = itemView.findViewById<TextView>(R.id.descriptionLine)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(article: listEquip) {
            titleTextView.text = article.name
            abstractTextView.text = article.url
        }

        override fun onClick(v: View?) {
            // TODO: Get selected article
            val item = listEquip[layoutPosition]

            // TODO: Navigate to Details screen and pass selected article
            val intent = Intent(context, IndivItemActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, item)
            context.startActivity(intent)
        }


    }


}