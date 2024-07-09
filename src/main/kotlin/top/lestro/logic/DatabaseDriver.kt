package top.lestro.logic

import top.lestro.db.major.MajorData
import top.lestro.db.major.MajorRepository
import top.lestro.logic.utils.B36
import top.lestro.logic.utils.decodeB36ToId
import top.lestro.logic.utils.encodeIdToB36

class DatabaseDriver {
    private val db = MajorRepository()

    suspend fun get(hash: B36): MajorData? {
        return db.get(hash.decodeB36ToId())
    }

    suspend fun getAll(): List<MajorData> {
        return db.getAll()
    }

    suspend fun add(endpoint: String): B36 {
        db.search(endpoint)?.let {
            return it.id.encodeIdToB36()
        }
        val id = db.add(endpoint)
        return id.encodeIdToB36()
    }

    suspend fun delete(hash: B36) {
        db.delete(hash.decodeB36ToId())
    }

}