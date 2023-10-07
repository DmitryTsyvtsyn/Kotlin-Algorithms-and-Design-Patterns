package design_patterns

/**
 *
 * pattern: Adapter
 *
 * using: used when we cannot directly use the functionality of an object
 *
 * description: to use the functionality of an object, a special class is created, which is called an adapter
 *
 */

interface Adapter<T> {
    fun getItem(position: Int) : T
    fun getItemCount() : Int
}

/**
 * here is a simplified imitation of RecyclerView component from Android
 */
class RecyclerView<T> {

    private var adapter: Adapter<T>? = null

    fun changeAdapter(adapter: Adapter<T>) {
        this.adapter = adapter
    }

    /**
     * renders elements from the adapter and returns a list of elements to test
     */
    fun draw() : List<T> {
        val items = mutableListOf<T>()
        val myAdapter = adapter
        if (myAdapter != null) {
            val count = myAdapter.getItemCount()
            for (i in 0 until count) {
                items.add(myAdapter.getItem(i))
                // draw item
            }
        }
        return items
    }

}