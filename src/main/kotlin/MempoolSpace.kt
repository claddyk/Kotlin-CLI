import kotlinx.serialization.*
import kotlinx.serialization.json.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*

suspend fun getBlockIds(startHeight: Int): String {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    val response: HttpResponse = client.get("https://mempool.space/api/v1/blocks/$startHeight")
    return response.bodyAsText()
}

suspend fun getTxIds(id: String): List<String> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    val response: HttpResponse = client.get("https://mempool.space/api/block/$id/txids")
    return Json.decodeFromString(response.toString())
}