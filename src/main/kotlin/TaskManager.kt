class TaskManager {
    private val taskList: MutableList<Task> = mutableListOf()

    fun createTask(title: String, description: String?) {
        val newTask = Task(title = title, description = description)
        taskList.add(newTask)
    }
}