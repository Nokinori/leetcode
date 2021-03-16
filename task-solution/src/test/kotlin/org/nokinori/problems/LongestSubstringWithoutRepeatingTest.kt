package org.nokinori.problems

import TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LongestSubstringWithoutRepeatingTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(s: String, expect: Int) {
        val result = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s)
        assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = Stream
            .of(
                TestCaseImpl(
                    input = "abcabcbb",
                    expect = 3
                ),
                TestCaseImpl(
                    input = "bbbbb",
                    expect = 1
                ),
                TestCaseImpl(
                    input = "pwwkew",
                    expect = 3
                ),
                TestCaseImpl(
                    input = "",
                    expect = 0
                ),
                TestCaseImpl(
                    input = "aab",
                    expect = 2
                ),
                TestCaseImpl(
                    input = "dvdf",
                    expect = 3
                )
            )
            .map { it.asArguments() }
    }


    data class TestCaseImpl(
        override val input: String,
        override val expect: Int
    ) : TestCase<String, Int> {
        override fun asArguments(): Arguments = Arguments.arguments(input, expect)
    }
}