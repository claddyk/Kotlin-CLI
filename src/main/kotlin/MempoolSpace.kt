import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

suspend fun fetchFirstBlockId(startHeight: Int): String {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }

    val response = client.get("https://mempool.space/api/v1/blocks/$startHeight").body<List<Block>>().first()
    return response.id
}
suspend fun fetchTransactionId(blockIds: String): Array<String> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
    val response = client.get("https://mempool.space/api/block/$blockIds/txids").body<Array<String>>()
    return response
}
