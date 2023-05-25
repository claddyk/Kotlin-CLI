import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TxIdsTest {
    @Test
    fun testDeserialize() {
        val json = """{"txids":["txid1","txid2","txid3"]}"""
        val txIds = Json.decodeFromString<TxIds>(json)
        assertEquals(listOf("txid1", "txid2", "txid3"), txIds.txids)
    }
}