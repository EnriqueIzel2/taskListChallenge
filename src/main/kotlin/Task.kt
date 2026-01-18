import java.time.LocalDateTime

data class Task(
    val id: Int = generateID(),
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        private var idCount = 0

        fun generateID(): Int {
            idCount += 1
            return idCount
        }
    }

    fun toSimpleString(): String = "($title, $isCompleted)"

    fun toDetailedString(): String {
        return "ID: $id | Título: $title | Concluído: $isCompleted | Criado em: $createdAt"
    }
}
