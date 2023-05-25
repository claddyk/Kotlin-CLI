import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {
    @Test
     fun testMain() {
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        val args = arrayOf("-s", "1")
        main(args)

        val expectedJson = """{"txids":["4a5e1e4baab89f3a32518a88c31bc87f618f76673e2cc77ab2127b7afdeda33b","f9d9bcc4ef5f8c238c2cfcce7a8b6e5b4f9d49e833d9f6b8f4b9b41b1b9f4f5b"]}"""
        assertEquals(expectedJson, outContent.toString().trim())
    }
}