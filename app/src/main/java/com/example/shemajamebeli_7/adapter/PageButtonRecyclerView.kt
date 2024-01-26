package com.example.shemajamebeli_7.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli_7.R
import com.example.shemajamebeli_7.databinding.PageButtonBinding
import com.example.shemajamebeli_7.model.PageButton

class PageButtonRecyclerView :
    ListAdapter<PageButton, PageButtonRecyclerView.PageButtonPageButtonViewHolder>(DiffUtil) {

    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<PageButton>() {
            override fun areItemsTheSame(oldItem: PageButton, newItem: PageButton): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PageButton, newItem: PageButton): Boolean {
                return oldItem == newItem
            }
        }
    }

    lateinit var onClick: (String) -> Unit
    private var oldItemPosition: Int = 0

    inner class PageButtonPageButtonViewHolder(private val binding: PageButtonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = currentList[adapterPosition]
            with(binding) {
                tvTitle.text = item.name
                ivIcon.setBackgroundResource(item.icon)
                if (!item.isActive) {
                    root.setBackgroundResource(R.drawable.side_nav_bar_shape)
                } else {
                    root.setBackgroundResource(R.drawable.checked_button_shape)
                }
            }
        }

        fun listener() {
            val item = currentList[adapterPosition]
            with(binding) {
                root.setOnClickListener {
                    if (oldItemPosition != adapterPosition) {
                        currentList[oldItemPosition].isActive = false
                        notifyItemChanged(oldItemPosition)

                        root.setBackgroundResource(R.drawable.checked_button_shape)
                        onClick(item.name)
                        oldItemPosition = adapterPosition
                    }
                }
            }
        }

        @SuppressLint("ResourceType")
        fun bindNotification() {
            val item = currentList[adapterPosition]
            if (item.messageNumber != null) {
                with(binding) {
                    tvMessageNumber.text = item.messageNumber.toString()
                    val colorCode = "#" + item.messageColor
                    val colorInt = Color.parseColor(colorCode)

                    cvMessageCard.apply {
                        setCardBackgroundColor(colorInt)
                        visibility = View.VISIBLE
                    }
                }
            } else {
                binding.cvMessageCard.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PageButtonPageButtonViewHolder {
        return PageButtonPageButtonViewHolder(
            PageButtonBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: PageButtonPageButtonViewHolder, position: Int) {
        with(holder) {
            bind()
            listener()
            bindNotification()
        }
    }
}