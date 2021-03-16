package org.nokinori.problems

import TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.fail
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class AddTwoNumbersTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun simpleSolution(l1: ListNode, l2: ListNode, expect: ListNode) {
        val result = AddTwoNumbers.addTwoNumbers(l1, l2)
        assertThat(result).isNotNull
        assertThat(result!!.`val`).isNotNull

        var expectNode: ListNode? = expect
        var resultNode: ListNode? = result
        while (expectNode != null) {
            assertThat(expectNode.`val`).isEqualTo(resultNode?.`val`)

            expectNode = expectNode.next
            resultNode = resultNode?.next
        }
        if (resultNode != null) {
            fail { "Result list is more then expected" }
        }
    }

    companion object {
        @Suppress("unused")
        @JvmStatic
        fun provideArguments(): Stream<Arguments> = Stream
            .of(
                TestCaseImpl(
                    input = ListNode(1) to ListNode(2),
                    expect = ListNode(3)
                ),
                TestCaseImpl(
                    input = asListNodes(2, 4, 3) to asListNodes(5, 6, 4),
                    expect = asListNodes(7, 0, 8)
                ),
                TestCaseImpl(
                    input = asListNodes(1, 2, 3, 4, 5, 6, 7, 8, 9) to asListNodes(9, 8, 7, 6, 5, 4, 3, 2, 1),
                    expect = asListNodes(0, 1, 1, 1, 1, 1, 1, 1, 1, 1)
                ),
                TestCaseImpl(
                    input = asListNodes(6, 5, 4) to asListNodes(4, 4, 4),
                    expect = asListNodes(0, 0, 9)
                )
            )
            .map { it.asArguments() }


        private fun asListNodes(vararg ints: Int): ListNode {
            val dummyHead = ListNode(-1)
            ints.map { ListNode(it) }
                .fold(dummyHead) { acc: ListNode, listNode: ListNode ->
                    acc.next = listNode
                    listNode
                }
            return dummyHead.next!!
        }
    }


    data class TestCaseImpl(
        override val input: Pair<ListNode, ListNode>,
        override val expect: ListNode
    ) : TestCase<Pair<ListNode, ListNode>, ListNode> {
        override fun asArguments(): Arguments = Arguments.arguments(input.first, input.second, expect)
    }
}