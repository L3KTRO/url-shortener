package top.lestro.db

import org.jetbrains.exposed.sql.Database

class DatabaseManager {
    val major = Database.connect(
        url = "jdbc:${System.getenv("DB_URL")}",
        driver = "org.postgresql.Driver",
        user = System.getenv("DB_USER"),
        password = System.getenv("DB_PASSWORD")
    )
}