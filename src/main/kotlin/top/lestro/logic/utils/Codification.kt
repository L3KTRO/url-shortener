package top.lestro.logic.utils

typealias B36 = String

fun Int.encodeIdToB36(): B36 {
    return this.toString(36)
}

fun String.decodeB36ToId(): Int {
    return Integer.parseInt(this, 36)
}

fun String.toB36(): B36 {
    return this
}