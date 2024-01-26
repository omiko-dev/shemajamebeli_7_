package com.example.shemajamebeli_7.model

data class PageButton (
    val id: Int,
    var messageNumber: Int? = null,
    val messageColor: String? = null,
    val icon: Int,
    val name: String,
    var isActive: Boolean = false
)