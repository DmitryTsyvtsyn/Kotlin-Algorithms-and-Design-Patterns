package other

import java.lang.Integer.min

/**
 *
 * Algorithm for determining the Levenshtein distance
 *
 */

class LevenshteinLength {

    /**
     * determines the Levenshtein distance for two strings and returns it
     */
    fun compute(str1: String, str2: String) : Int {
        val matrix = Array(str1.length + 1) {
            Array(str2.length + 1) { 0 }
        }

        for (i in 0..str1.length) {
            matrix[i][0] = i
        }

        for (i in 0..str2.length) {
            matrix[0][i] = i
        }

        for (i in 1..str1.length) {
            for (j in 1..str2.length) {
                if (str1[i - 1] == str2[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1]
                } else {
                    matrix[i][j] = min(min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1
                }
            }
        }

        return matrix[str1.length][str2.length]
    }

}