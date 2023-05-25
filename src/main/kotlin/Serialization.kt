import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class BlockIds(val id: String)
data class TxIds(val txids: List<String>)
