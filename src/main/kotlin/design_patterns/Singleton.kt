package design_patterns

/**
 *
 * Singleton is a generative design pattern that guarantees the existence of one instance of a class
 *
 * and provides a global access point to it
 *
 */

object SQLiteDatabase {

    // SQLiteDatabase instance state
    private var connectionId = -1

    // These methods provide a global access point to SQLiteDatabase instance state
    fun openConnection() {
        if (connectionId < 0) {
            // open connection...
            connectionId = 1
        }
    }

    fun execSQL(sql: String): List<String> {
        if (connectionId < 0) return emptyList()
        return when (sql) {
            "select * from names" -> listOf("Rick", "Morty", "Jerry", "Beth")
            else -> emptyList()
        }
    }

    fun closeConnection() {
        if (connectionId > 0) {
            // close connection...
            connectionId = -1
        }
    }

}