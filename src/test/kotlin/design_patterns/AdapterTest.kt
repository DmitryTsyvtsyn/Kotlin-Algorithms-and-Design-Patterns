package design_patterns

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class AdapterTest {

    @Test
    fun test() {
        val list = RecyclerView<Int>()
        val items = listOf(1, 2, 3)
        list.changeAdapter(object: Adapter<Int> {
            override fun getItem(position: Int) = items[position]
            override fun getItemCount() = items.size
        })
        val drawItems = list.draw()
        assertEquals(items, drawItems)
    }

}