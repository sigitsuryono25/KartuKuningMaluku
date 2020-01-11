package com.surelabs.auto.kartukuningmaluku.network.datamodel.list.news

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class DataItem(

    @field:SerializedName("id_news")
    val idNews: String? = null,

    @field:SerializedName("fitur_photo")
    val fiturPhoto: String? = null,

    @field:SerializedName("judul")
    val judul: String? = null,

    @field:SerializedName("added_on")
    val addedOn: String? = null,

    @field:SerializedName("isi")
    val isi: String? = null
) : Serializable