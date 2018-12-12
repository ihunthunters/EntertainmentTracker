package com.hjames.entertainme.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.hjames.entertainme.R

class EntertainmentAdapter(private val myDataset: Array<String>) :
        RecyclerView.Adapter<EntertainmentAdapter.ItemViewHolder>() {

    class ItemViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): EntertainmentAdapter.ItemViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
                .inflate(R.layout.anime_list_item, parent, false) as TextView
        // set the view's size, margins, paddings and layout parameters
        // ...
        return ItemViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = myDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}