package com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResponseListNews(

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("error")
    val error: Int? = null
)