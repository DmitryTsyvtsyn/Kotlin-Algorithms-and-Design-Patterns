package other

class Euclid {

    fun compute(num1: Int, num2: Int) : Int {
        var copyNum1 = num1
        var copyNum2 = num2
        while (copyNum1 != copyNum2) {
            if (copyNum1 > copyNum2) {
                copyNum1 -= copyNum2
            } else {
                copyNum2 -= copyNum1
            }
        }
        return copyNum1
    }

}