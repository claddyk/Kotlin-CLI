import kotlinx.cli.*
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking() {
    val parser = ArgParser("kotlin-cli")
    val startHeight by parser.option(ArgType.Int, shortName = "s", description = "Start Height").required()

    parser.parse(args)

    val blockIds = fetchFirstBlockId(startHeight)
    println(blockIds)

    val txid = fetchTransactionId(blockIds)
    txid.forEach { println(it) }
}