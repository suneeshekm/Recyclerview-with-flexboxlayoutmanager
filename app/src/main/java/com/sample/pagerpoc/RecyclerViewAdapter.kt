package com.sample.pagerpoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayoutManager

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var listItems: MutableList<String> = mutableListOf<String>("a","b","c","d","e","f")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val item = listItems[position]
        var msg = "Sample item no:$position "
        for(i in 0..position){
            msg += "dynamic content \n"
        }
        holder.textViewName.text = msg
        holder.itemView.setOnClickListener {
            val pos = listItems.indexOf(item)
            listItems.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }



    override fun getItemCount(): Int {
        return listItems.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: TextView = itemView.findViewById(R.id.textViewName)
        init {
            updateLayoutParamsToAllowHorizontalScrolling()
        }
        private fun updateLayoutParamsToAllowHorizontalScrolling() {
            (itemView.layoutParams as? FlexboxLayoutManager.LayoutParams)?.let {
                it.flexShrink = 0.0f
                it.alignSelf = AlignItems.FLEX_START
            }
        }
    }
}