package com.example.mydemo.model
import com.google.gson.annotations.SerializedName


data class CoinModel(
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("msg")
    var msg: String?,
    @SerializedName("result")
    var result: Int?
)

data class Data(
    @SerializedName("itemsPerPage")
    var itemsPerPage: Int?,
    @SerializedName("list")
    var list: MutableList<CoinData?>?= mutableListOf(),
    @SerializedName("startIndex")
    var startIndex: Int?,
    @SerializedName("totalItems")
    var totalItems: Int?
)

data class CoinData (
    @SerializedName("age")
    var age: Int?,
    @SerializedName("history")
    var history: String?,
    @SerializedName("_id")
    var id: String?,
    @SerializedName("isCoin")
    var isCoin: Boolean?,
    @SerializedName("isGraded")
    var isGraded: Boolean?,
    @SerializedName("isSold")
    var isSold: Boolean?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("pictures")
    var pictures: Pictures?,
    @SerializedName("price")
    var price: Int?,
    @SerializedName("tags")
    var tags: List<String?>?,
    @SerializedName("year")
    var year: Int?
)

data class Pictures(
    @SerializedName("back")
    var back: Back?,
    @SerializedName("front")
    var front: Front?
)

data class Back(
    @SerializedName("key")
    var key: String?,
    @SerializedName("sizeInMegaByte")
    var sizeInMegaByte: Double?,
    @SerializedName("url")
    var url: String?
)

data class Front(
    @SerializedName("key")
    var key: String?,
    @SerializedName("sizeInMegaByte")
    var sizeInMegaByte: Double?,
    @SerializedName("url")
    var url: String?
)