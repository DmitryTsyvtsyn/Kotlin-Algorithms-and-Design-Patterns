package other

class Swap {
    
    private fun  List<Int>.inIndex(index: Int) = index in 0 until size
    
    private fun Array<Int>.inIndex(index: Int) = index in 0 until size
    
    fun swap(list: MutableList<Int>, old: Int, new: Int) {
        if (list.inIndex(old) && list.inIndex(new)) {
            list[old] = list[old] + list[new]
            list[new] = list[old] - list[new]
            list[old] = list[old] - list[new]
        }
    }

    fun swap(array: Array<Int>, old: Int, new: Int) {
        if (array.inIndex(old) && array.inIndex(new)) {
            array[old] = array[old] + array[new]
            array[new] = array[old] - array[new]
            array[old] = array[old] - array[new]
        }
    }
}