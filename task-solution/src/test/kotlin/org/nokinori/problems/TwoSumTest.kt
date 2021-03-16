package org.nokinori.problems

import TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import org.nokinori.problems.TwoSum.twoSum
import java.util.stream.Stream


internal class TwoSumTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(nums: List<Int>, target: Int, expect: List<Int>) {
        val result = twoSum(nums.toIntArray(), target)
        Assertions.assertThat(result).containsExactlyInAnyOrder(*expect.toIntArray())
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = Stream
            .of(
                TestCaseImpl(input = listOf(2, 7, 11, 15) to 9, expect = listOf(0, 1)),
                TestCaseImpl(input = listOf(3, 2, 4) to 6, expect = listOf(1, 2)),
                TestCaseImpl(input = listOf(3, 3) to 6, expect = listOf(0, 1)),
                TestCaseImpl(input = listOf(1, 3, 6, 7, 4, 5) to 12, expect = listOf(3, 5)),
            )
            .map { it.asArguments() }

    }

    data class TestCaseImpl(
        override val input: Pair<List<Int>, Int>,
        override val expect: List<Int>
    ) : TestCase<Pair<List<Int>, Int>, List<Int>> {
        override fun asArguments(): Arguments = arguments(input.first, input.second, expect)
    }
}


