import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class TxIds(val txids: List<String>)