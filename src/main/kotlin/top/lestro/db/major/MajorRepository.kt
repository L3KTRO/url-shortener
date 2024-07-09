package top.lestro.db.major

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import top.lestro.db.utils.Repository

class MajorRepository : Repository() {
    object Redirects : IntIdTable() {
        val endpoint = varchar("endpoint", 255)
        val date = long("date").default(System.currentTimeMillis())
    }

    init {
        transaction {
            SchemaUtils.create(Redirects)
        }
    }

    suspend fun add(endpoint: String) = dbQuery {
        Redirects.insertAndGetId {
            it[Redirects.endpoint] = endpoint
        }.value
    }

    suspend fun get(id: Int) = dbQuery {
        Redirects.selectAll().where { Redirects.id eq id }.map {
            MajorData(
                it[Redirects.id].value, it[Redirects.endpoint], it[Redirects.date]
            )
        }.firstOrNull()
    }

    suspend fun search(endpoint: String) = dbQuery {
        Redirects.selectAll().where { Redirects.endpoint eq endpoint }.map {
            MajorData(
                it[Redirects.id].value, it[Redirects.endpoint], it[Redirects.date]
            )
        }.firstOrNull()
    }

    suspend fun delete(id: Int) = dbQuery {
        Redirects.deleteWhere { Redirects.id eq id }
    }

    suspend fun getAll() = dbQuery {
        Redirects.selectAll().map {
            MajorData(
                it[Redirects.id].value, it[Redirects.endpoint], it[Redirects.date]
            )
        }
    }
}