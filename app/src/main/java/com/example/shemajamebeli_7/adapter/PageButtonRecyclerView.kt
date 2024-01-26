package com.example.shemajamebeli_7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli_7.R
import com.example.shemajamebeli_7.databinding.PageButtonBinding
import com.example.shemajamebeli_7.model.PageButton

class PageButtonRecyclerView :
    RecyclerView.Adapter<PageButtonRecyclerView.PageButtonPageButtonViewHolder>() {

    private var buttonInfoList: MutableList<PageButton> = mutableListOf()


    inner class PageButtonPageButtonViewHolder(private val binding: PageButtonBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(){
                val item = buttonInfoList[adapterPosition]
                with(binding){
                    tvTitle.text = item.name
                    ivIcon.setBackgroundResource(item.icon)
                }
            }
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PageButtonPageButtonViewHolder {
        return PageButtonPageButtonViewHolder(
            PageButtonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return buttonInfoList.count()
    }

    override fun onBindViewHolder(holder: PageButtonPageButtonViewHolder, position: Int) {
        holder.bind()
    }


    fun getItems(items: MutableList<PageButton>) {
        buttonInfoList = items
    }
}