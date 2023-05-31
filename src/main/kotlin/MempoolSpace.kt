import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.*

suspend fun fetchBlocks(startHeight: Int): Block? {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }
    return try {
        client.get("https://mempool.space/api/v1/blocks/$startHeight").body<Block>()
    } catch (e: Throwable) {
        println(e.message)
        null
    }
}
