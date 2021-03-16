package org.nokinori.problems

import kotlin.math.nextDown
import kotlin.math.nextUp

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 */
object MedianOfTwoSortedArrays {
    /**
     * Easy-peasy, lemon squeezy :)
     * But also there is some way to properly merge 2 arrays. Mb with case of merge sort.
     * But why do i need to do that by my own?)
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergedArray = (nums1 + nums2).apply { sort() }
        return findMedian(mergedArray)
    }

    private fun findMedian(array: IntArray): Double =
        if (array.size % 2 != 0) {
            array[array.size / 2].toDouble()
        } else {
            val middle = array.size / 2.0
            val x = array[middle.nextDown().toInt()]
            val y = array[middle.nextUp().toInt()]
            (x + y) / 2.0
        }
}