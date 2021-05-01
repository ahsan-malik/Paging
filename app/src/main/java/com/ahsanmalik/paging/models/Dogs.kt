package com.ahsanmalik.paging.models

data class Dogs(
    val breeds:List<Breeds>?,
    val url:String?
)

data class Breeds(
    val id:Int?,
    val name:String?
)