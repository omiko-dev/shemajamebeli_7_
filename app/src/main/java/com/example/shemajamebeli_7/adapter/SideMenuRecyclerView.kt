package com.example.shemajamebeli_7.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli_7.R
import com.example.shemajamebeli_7.databinding.SideMenuBinding
import com.example.shemajamebeli_7.model.PageButton

class SideMenuRecyclerView : RecyclerView.Adapter<SideMenuRecyclerView.SideMenuViewHolder>() {

    private val pageButtonList: MutableList<PageButton> = mutableListOf(
        PageButton(
            icon = R.drawable.ic_dash_board,
            name = "Dashboard",
            notificationNumber = 0
        ),
        PageButton(
            icon = R.drawable.ic_email,
            name = "Mail",
            notificationNumber = 1
        ),
        PageButton(
            icon = R.drawable.ic_notification,
            name = "Notification",
            notificationNumber = 12
        ),
        PageButton(
            icon = R.drawable.ic_calendar,
            name = "Calendar",
            notificationNumber = 0
        ),
        PageButton(
            icon = R.drawable.ic_setting,
            name = "Setting",
            notificationNumber = 0
        ),
    )

     private lateinit var adapter: PageButtonRecyclerView

    inner class SideMenuViewHolder(private val binding: SideMenuBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(){
                adapter = PageButtonRecyclerView()
                with(binding){
                    pageRecycler.adapter = adapter
                    pageRecycler.layoutManager = LinearLayoutManager(binding.root.context)

                    rgSection.setOnCheckedChangeListener { _, checkedId ->
                        when(checkedId){
                            rbBusiness.id -> {
                                rbBusiness.setBackgroundResource(R.drawable.checked_radio_button)
                                rbPersonal.setBackgroundResource(R.drawable.button_border_shape)
                            }
                            rbPersonal.id -> {
                                rbBusiness.setBackgroundResource(R.drawable.checked_radio_button)
                                rbBusiness.setBackgroundResource(R.drawable.button_border_shape)
                            }
                        }
                    }

                }
                adapter.getItems(pageButtonList)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SideMenuViewHolder {
        return SideMenuViewHolder(
            SideMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: SideMenuViewHolder, position: Int) {
        holder.bind()
    }

}