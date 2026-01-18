class TaskManager {
    private val taskList: MutableList<Task> = mutableListOf()

    fun createTask(title: String, description: String?) : TaskResult {
        return try {
            require(title.isNotBlank()) { "O título não pode estar vazio!" }

            val newTask = Task(title = title, description = description)
            taskList.add(newTask)

            TaskResult.Success("Tarefa adicionada com sucesso ID: ${newTask.id}", newTask)
        } catch (e: Exception) {
            TaskResult.Error(e.message ?: "Erro desconhecido")
        }
    }

    fun listTasks(tasks: List<Task> = taskList) {
        if (tasks.isEmpty()) {
            println("Nenhuma tarefa encontrada")
        } else {
            tasks.forEach { println(it.toSimpleString()) }
        }
    }

    fun getTask(id: Int) : Task? {
        return taskList.find { it.id == id }
    }

    fun delete(id: Int) : TaskResult {
        return try {
            val task = taskList.find { it.id == id }
            require(task != null) { "O ID da tarefa não existe" }
            taskList.removeIf { it.id == id }

            TaskResult.Success("Tarefa excluída com sucesso")
        } catch (e: Exception) {
            TaskResult.Error(e.message ?: "Erro ao excluir Mensagem")
        }
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