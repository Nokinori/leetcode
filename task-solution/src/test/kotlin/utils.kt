import org.junit.jupiter.params.provider.Arguments

interface TestCase<IN, EX> {
    val input: IN
    val expect: EX
    fun asArguments(): Arguments
}
