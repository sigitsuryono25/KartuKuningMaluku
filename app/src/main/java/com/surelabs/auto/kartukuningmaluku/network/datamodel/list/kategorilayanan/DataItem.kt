package com.surelabs.auto.kartukuningmaluku.network.datamodel.list.kategorilayanan

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class DataItem(

    @field:SerializedName("id_kategori")
    val idKategori: String? = null,

    @field:SerializedName("nama_kategori")
    val namaKategori: String? = null
) : Serializable