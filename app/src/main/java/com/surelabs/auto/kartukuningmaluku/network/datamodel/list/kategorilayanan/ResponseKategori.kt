package com.surelabs.auto.kartukuningmaluku.network.datamodel.list.kategorilayanan

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ResponseKategori(

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("error")
    val error: Int? = null
)