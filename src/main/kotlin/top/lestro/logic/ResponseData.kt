package top.lestro.logic

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val code: Int,
    val message: String
)
