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
            """
        ) }
    }

    fun getTask(id: Int) : Task? {
        return taskList.find { it.id == id }
    }

    fun delete(id: Int) : Boolean {
        return taskList.removeIf { it.id == id }
    }

    fun update(taskUpdated: Task) {
        val index = taskList.indexOfFirst { it.id == taskUpdated.id }

        if (index != -1) {
            taskList[index] = taskUpdated
        }
    }

    fun countTasks() : Int {
        return taskList.size
    }

    fun getCompletedTasks() : List<Task> {
        return taskList.filter { it.isCompleted }
    }

    fun getPendingTasks() : List<Task> {
        return taskList.filter { !it.isCompleted }
    }
}