sealed class TaskResult {
    data class Success(
        val message: String,
        val task: Task? = null
    ) : TaskResult()

    data class Error(
        val message: String
    ) : TaskResult()
}