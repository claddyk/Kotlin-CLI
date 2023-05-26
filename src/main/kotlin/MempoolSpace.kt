import kotlinx.serialization.*
import kotlinx.serialization.json.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

data class BlockInfo(
    val id: String,
    val height: Int,
    // Include other properties as needed
)

suspend fun getBlockIds(startHeight: Int): List<String> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    val response = client.get<List<BlockInfo>>("https://mempool.space/api/v1/blocks/$startHeight")
    val blockId = response[0].id
    return getTxIds(blockId)
}

suspend fun getTxIds(id: String): List<String> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    return client.get<List<String>>("https://mempool.space/api/block/$id/txids")
}
