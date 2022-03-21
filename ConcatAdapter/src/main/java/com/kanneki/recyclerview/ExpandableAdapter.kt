package com.kanneki.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.kanneki.recyclerview.databinding.ExpandableHeaderBinding
import com.kanneki.recyclerview.databinding.ExpandableItemBinding

class ExpandableAdapter(
    private val groupItem: GroupItem
) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_ITEM = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                ViewHolder.HeaderViewHolder(
                    ExpandableHeaderBinding.inflate(layoutInflater, parent, false),
                )
            }
            else -> {
                ViewHolder.ItemViewHolder(
                    ExpandableItemBinding.inflate(layoutInflater, parent, false)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       when(holder) {
           is ViewHolder.HeaderViewHolder -> holder.bind(groupItem)
           is ViewHolder.ItemViewHolder -> holder.bind(groupItem, position)
       }
    }

    override fun getItemCount(): Int {
        return groupItem.itemList.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_HEADER
        } else {
            VIEW_TYPE_ITEM
        }
    }

}

sealed class ViewHolder(itemView: ViewBinding) : RecyclerView.ViewHolder(itemView.root) {

    class HeaderViewHolder(val binding: ExpandableHeaderBinding) : ViewHolder(binding) {

        fun bind(item: GroupItem) {
            binding.headerTextView.text = item.header.headerText
        }
    }

    class ItemViewHolder(val binding: ExpandableItemBinding) : ViewHolder(binding) {
        fun bind(item: GroupItem, position: Int) {
            binding.textView.text = item.itemList[position - 1].itemText
        }

    }
}