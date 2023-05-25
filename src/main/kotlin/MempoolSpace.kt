import kotlinx.serialization.*
import kotlinx.serialization.json.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

@Serializable
data class BlockIds(val id: String)

suspend fun getBlockIds(startHeight: Int): BlockIds {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    val response = client.get<String>("https://mempool.space/api/v1/blocks/$startHeight")
    return Json.decodeFromString(response)
}

suspend fun getTxIds(id: String): List<String> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    val response = client.get<String>("https://mempool.space/api/block/$id/txids")
    return Json.decodeFromString(response)
}