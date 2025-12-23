import java.time.LocalDateTime

data class Task(
    val id: Int = gerenateID(),
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        private var idCount = 1

        fun gerenateID(): Int {
            idCount += 1
            return idCount
        }
    }
}
