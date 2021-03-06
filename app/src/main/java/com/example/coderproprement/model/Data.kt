package fr.quentin.android3.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("results") val result: ArrayList<Characters>,

    )
