package org.nokinori.template

import TestCase
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class TestClassTemplate {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(input: Int, expect: Int) {
        val result = expect
        Assertions.assertThat(result).isEqualTo(expect)
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = Stream
            .of(
                TestCaseImpl(input = 1, expect = 1),
            )
            .map { it.asArguments() }

    }

    data class TestCaseImpl(
        override val input: Int,
        override val expect: Int
    ) : TestCase<Int, Int> {
        override fun asArguments(): Arguments = Arguments.arguments(input, expect)
    }
}