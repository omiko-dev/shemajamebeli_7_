package com.example.shemajamebeli_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli_7.adapter.PageButtonRecyclerView
import com.example.shemajamebeli_7.databinding.ActivityMainBinding
import com.example.shemajamebeli_7.databinding.SideMenuBinding
import com.example.shemajamebeli_7.model.PageButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val pageButtonList: MutableList<PageButton> = mutableListOf(
        PageButton(
            id = 0,
            icon = R.drawable.ic_dash_board,
            name = "Dashboard",
            messageNumber = 15,
            messageColor = "fc6434",
            isActive = true
        ),
        PageButton(
            id = 1,
            icon = R.drawable.ic_email,
            name = "Mail"
        ),
        PageButton(
            id = 2,
            icon = R.drawable.ic_notification,
            name = "Notification",
            messageColor = "332332",
            messageNumber = 10
        ),
        PageButton(
            id = 3,
            icon = R.drawable.ic_calendar,
            name = "Calendar"
        ),
        PageButton(
            id = 4,
            icon = R.drawable.ic_setting,
            name = "Setting"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val headerView = binding.nvBar.getHeaderView(0)
        val headerBinding = SideMenuBinding.bind(headerView)
        val adapter = PageButtonRecyclerView()
        adapter.submitList(pageButtonList)

        bindRecycler(headerBinding, adapter)
        bindCategoryRadioButton(headerBinding)
        sideBarNavigation(adapter)
    }

    private fun bindRecycler(binding: SideMenuBinding, adapter: PageButtonRecyclerView) {
        with(binding) {
            pageRecycler.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                this.adapter = adapter
            }
        }
    }

    private fun bindCategoryRadioButton(binding: SideMenuBinding) {
        with(binding) {
            rgSection.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    rbBusiness.id -> {
                        rbBusiness.setBackgroundResource(R.drawable.checked_radio_button)
                        rbPersonal.setBackgroundResource(R.drawable.button_border_shape)
                    }

                    rbPersonal.id -> {
                        rbPersonal.setBackgroundResource(R.drawable.checked_radio_button)
                        rbBusiness.setBackgroundResource(R.drawable.button_border_shape)
                    }
                }
            }
        }
    }

    private fun sideBarNavigation(adapter: PageButtonRecyclerView) {
        adapter.onClick = {
            when (it) {
                SideBarNavigationEnum.CALENDAR.direction -> {

                }

                SideBarNavigationEnum.DASHBOARD.direction -> {

                }

                SideBarNavigationEnum.MAIL.direction -> {

                }

                SideBarNavigationEnum.SETTING.direction -> {

                }

                SideBarNavigationEnum.NOTIFICATION.direction -> {

                }
            }
        }
    }

    enum class SideBarNavigationEnum(val direction: String) {
        DASHBOARD("Dashboard"), MAIL("Mail"), NOTIFICATION("Notification"), CALENDAR("Calendar"), SETTING(
            "Setting"
        ),
    }
}

