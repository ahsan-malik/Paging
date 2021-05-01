package com.ahsanmalik.paging.models


data class StackApiResponse (
    val items: List<Item>,
    val has_more: Boolean,
    val quota_max: Int,
    val quota_remaining: Int,
    val backoff: Int
)

data class Owner (
    val reputation: Int,
    val user_id: Int,
    val user_type: String,
    val profile_image: String,
    val display_name: String,
    val link: String? = null
)

data class Item (
    val owner: Owner,
    val is_accepted: Boolean,
    val score: Int,
    val last_activity_date: Long,
    val creation_date: Long,
    val answer_id: Long,
    val question_id: Long,
    val content_license: String
)