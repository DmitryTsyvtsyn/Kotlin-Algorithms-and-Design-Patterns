package other

class ReverseArray<T> {

    fun compute(array: Array<T>) : Array<T> {
        val newArray = array.copyOf()
        for (index in 0 until array.size / 2) {
            newArray[index] = newArray[array.size - index - 1].apply {
                newArray[array.size - index - 1] = newArray[index]
            }
        }
        return newArray
    }
}