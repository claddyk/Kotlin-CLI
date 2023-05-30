import kotlinx.serialization.Serializable

@Serializable
data class BlockIds(val id: String)
@Serializable
data class TxIds(val id: List<String>)