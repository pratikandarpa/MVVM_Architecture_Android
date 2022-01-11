package com.example.mvvm_architecture.diff_util_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_architecture.R

class ProgrammingAdapter :
    ListAdapter<ProgrammingData, ProgrammingAdapter.ProgrammingViewHolder>(DiffUtilClass()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ProgrammingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.findViewById<TextView>(R.id.tvName)
        var tvIcon = itemView.findViewById<TextView>(R.id.tvIcon)

        fun bind(item: ProgrammingData) {
            tvName.text = item.name
            tvIcon.text = item.Initial
        }
    }

    class DiffUtilClass : DiffUtil.ItemCallback<ProgrammingData>() {
        override fun areItemsTheSame(oldItem: ProgrammingData, newItem: ProgrammingData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingData,
            newItem: ProgrammingData
        ): Boolean {
            return oldItem == newItem
        }

    }
}