package com.surelabs.auto.kartukuningmaluku.network.datamodel.list.lowker

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class DataItem(

    @field:SerializedName("id_lowongan")
    val idLowongan: String? = null,

    @field:SerializedName("isi_lowongan")
    val isiLowongan: String? = null,

    @field:SerializedName("dilihat")
    val dilihat: String? = null,

    @field:SerializedName("fitur_photo")
    val fiturPhoto: String? = null,

    @field:SerializedName("posisi")
    val posisi: String? = null,

    @field:SerializedName("judul")
    val judul: String? = null,

    @field:SerializedName("added_on")
    val addedOn: String? = null
) : Serializable