package org.nokinori.problems

import kotlin.math.max

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
object LongestSubstringWithoutRepeating {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        var maxSubstringSize = 0
        val chars = s.toCharArray()

        var index = 0
        var slideIndex = 0
        val substring = mutableSetOf<Char>()

        while (index != chars.size && slideIndex != chars.size) {
            val currentChar = chars[slideIndex]

            if (!substring.contains(currentChar)) {
                substring.add(currentChar)
                slideIndex++
                val rangeOfSubstring = slideIndex - index
                maxSubstringSize = max(maxSubstringSize, rangeOfSubstring)
            } else {
                val firstElementInSubstring = chars[index]
                substring.remove(firstElementInSubstring)
                index++
            }
        }
        return maxSubstringSize
    }
}