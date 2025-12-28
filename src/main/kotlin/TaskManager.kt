class TaskManager {
    private val taskList: MutableList<Task> = mutableListOf()

    fun createTask(title: String, description: String?) : Task {
        val newTask = Task(title = title, description = description)
        taskList.add(newTask)

        return newTask
    }

    fun listTasks() {
        taskList.forEach { task -> println(
            """
            ID: ${task.id}
            TITLE: ${task.title}
            DESCRIPTION: ${task.description}
            STATUS FEITO: ${task.isCompleted }
            """
        ) }
    }

    fun getTask(id: Int) : Task? {
        return taskList.find { it.id == id}
    }
}