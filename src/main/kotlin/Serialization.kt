import kotlinx.serialization.*

@Serializable
data class BlockIds(val id: String)
data class TxIds(val id: List<String>)