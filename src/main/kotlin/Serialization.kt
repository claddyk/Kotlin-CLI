import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Block(
    val id: String,
    val timestamp: Long,
    val height: Int,
    val version: Int,
    val bits: Int,
    val nonce: Long,
    val difficulty: Double,
    @SerialName("merkle_root")
    val merkleRoot: String,
    @SerialName("tx_count")
    val txCount: Int,
    val size: Int,
    val weight: Int,
    @SerialName("previousblockhash")
    val previousBlockHash: String,
    val extras: Extras
)

@Serializable
data class Extras(
    @SerialName("coinbaseRaw")
    val coinbaseRaw: String,
    val medianFee: Int,
    val feeRange: List<Int>,
    val reward: Int,
    val totalFees: Int,
    val avgFee: Int,
    val avgFeeRate: Int,
    val pool: Pool
)

@Serializable
data class Pool(
    val id: Int,
    val name: String,
    val slug: String
)
