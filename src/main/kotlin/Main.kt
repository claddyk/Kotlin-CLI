import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking() {
    val firstId = fetchFirstBlockId(730000)

    println(firstId)
}