package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class SingletonTest {

    @Test
    fun test() {
        // we have one instance of SQLiteDatabase class
        SQLiteDatabase.openConnection()

        val actual = SQLiteDatabase.execSQL("select * from names")
        val expected = listOf("Rick", "Morty", "Jerry", "Beth")

        assertEquals(expected, actual)

        SQLiteDatabase.closeConnection()
    }

}