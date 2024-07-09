package top.lestro.db.major

import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class MajorData(
    val id: Int,
    val endpoint: String,
    val date: Long = Date().time
)