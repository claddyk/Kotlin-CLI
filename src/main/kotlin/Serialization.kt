import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class BlockIds(val data: Data)

@Serializable
data class Data(val id: String)