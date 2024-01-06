
import kotlin.random.Random

object TestUtils {

    fun randomArray(size: Int) =  List(size) { Random.nextInt(100) }.toTypedArray()
    fun sortedArray(size: Int) = List(size) { it }.toTypedArray()

    fun mutableRandomList(size: Int) = List(size) { Random.nextInt(100) }.toMutableList()
    fun list(size: Int) = List(size) { it }


}