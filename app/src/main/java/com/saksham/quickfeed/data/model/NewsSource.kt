package com.saksham.quickfeed.data.model
import kotlinx.serialization.Serializable

@Serializable
class NewsSource(
    val name: String,
    val url: String
){

}
