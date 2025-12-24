fun main () {
    var option: Int = 0

    val taskManager = TaskManager()

    while (option != 1) {
        println("Nome da tarefa")
        val titleTask = readlnOrNull().toString()

        println("Descrição da tarefa")
        val descriptionTask = readlnOrNull().toString()

        taskManager.createTask(titleTask, descriptionTask)

        println("a classe foi criada")

        option = 1
    }
}