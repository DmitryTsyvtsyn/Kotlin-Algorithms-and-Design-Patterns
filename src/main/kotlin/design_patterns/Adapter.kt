package design_patterns

/**
 * название: паттерн Adapter
 *
 * применение: используется когда мы не можем напрямую использовать функциональность объекта
 *
 * описание: для использования функциональности объекта создается специальный класс, который называется адаптером
 */

interface Adapter<T> {
    fun getItem(position: Int) : T
    fun getItemCount() : Int
}

/**
 * здесь приведена упрощенная имитация RecyclerView компонента из Android
 */
class RecyclerView<T> {

    /**
     * хранит ссылку на адаптер
     */
    private var adapter: Adapter<T>? = null

    /**
     * изменяет текущий адаптер на новый
     *
     * @adapter - новый адаптер
     */
    fun changeAdapter(adapter: Adapter<T>) {
        this.adapter = adapter
    }

    /**
     * отрисовывает элементы из адаптера
     *
     * возвращает список элементов для тестирования
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