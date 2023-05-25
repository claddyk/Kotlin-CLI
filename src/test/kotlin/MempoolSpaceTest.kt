import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MyTest {
    @Test
    fun testGetBlockIds() {
        runBlocking {
            val blockIds = getBlockIds(1)
            assertEquals("00000000839a8e6886ab5951d76f411475428afc90947ee320161bbf18eb6048", blockIds.id)
        }
    }

    @Test
    fun testGetTxIds() {
        runBlocking {
            val txIds = getTxIds("00000000839a8e6886ab5951d76f411475428afc90947ee320161bbf18eb6048")
            assertEquals(2, txIds.size)
            assertEquals("4a5e1e4baab89f3a32518a88c31bc87f618f76673e2cc77ab2127b7afdeda33b", txIds[0])
            assertEquals("f9d9bcc4ef5f8c238c2cfcce7a8b6e5b4f9d49e833d9f6b8f4b9b41b1b9f4f5b", txIds[1])
        }
    }
}