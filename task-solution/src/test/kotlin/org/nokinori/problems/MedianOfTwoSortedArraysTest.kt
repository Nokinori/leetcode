package org.nokinori.problems

import TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MedianOfTwoSortedArraysTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(nums1: List<Int>, nums2: List<Int>, expect: Double) {
        val result = MedianOfTwoSortedArrays.findMedianSortedArrays(nums1.toIntArray(), nums2.toIntArray())
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = Stream
            .of(
                TestCaseImpl(
                    input = listOf(1, 3) to listOf(2),
                    expect = 2.0
                ),
                TestCaseImpl(
                    input = listOf(1, 2) to listOf(3, 4),
                    expect = 2.5
                ),
                TestCaseImpl(
                    input = listOf(0, 0) to listOf(0, 0),
                    expect = 0.0
                ),
                TestCaseImpl(
                    input = emptyList<Int>() to listOf(1),
                    expect = 1.0
                ),
                TestCaseImpl(
                    input = listOf(2) to emptyList(),
                    expect = 2.0
                ),
            )
            .map { it.asArguments() }

    }

    data class TestCaseImpl(
        override val input: Pair<List<Int>, List<Int>>,
        override val expect: Double
    ) : TestCase<Pair<List<Int>, List<Int>>, Double> {
        override fun asArguments(): Arguments = Arguments.arguments(input.first, input.second, expect)
    }
}