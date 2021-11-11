package other

class Swap {
    
    private fun  List<Int>.inIndex(index: Int) = index in 0 until size
    
    private fun Array<Int>.inIndex(index: Int) = index in 0 until size
    
    fun swap(list: MutableList<Int>, old: Int, new: Int) {
        if (list.inIndex(old) && list.inIndex(new)) {
            val sum = list[old] + list[new]
            list[new] = sum - list[new]
            list[old] = sum - list[new]
        }
    }

    fun swap(array: Array<Int>, old: Int, new: Int) {
        if (array.inIndex(old) && array.inIndex(new)) {
            val sum = array[old] + array[new]
            array[new] = sum - array[new]
            array[old] = sum - array[new]
        }
    }
}