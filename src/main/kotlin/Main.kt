import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json



fun main() = runBlocking{
    val block = fetchBlocks(73000)
    println(block)
}