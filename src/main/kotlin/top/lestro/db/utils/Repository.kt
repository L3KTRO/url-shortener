package top.lestro.db.utils

import top.lestro.db.DatabaseManager
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

abstract class Repository {
    private val database = DatabaseManager().major

    init {
        transaction(database) {
            exec("CREATE SCHEMA IF NOT EXISTS public;")
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T {
        return newSuspendedTransaction(Dispatchers.IO) { block() }
    }
}