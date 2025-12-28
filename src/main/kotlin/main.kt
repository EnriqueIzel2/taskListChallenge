fun main () {
    var option: Int? = 0

    val taskManager = TaskManager()

    while (option != 5) {

        println(
            """
        +---------------------------------+
        |  CONTROLE DE TAREFAS |
        +---------------------------------+
        |  0 - Listar Tarefas             |
        |  1 - Adicionar                  |
        |  2 - Atualizar                  |
        |  3 - Deletar                    |
        |  4 - Buscar                     |
        |  5 - Sair                       |
        +---------------------------------+
        """
        )
        option = readlnOrNull()?.toIntOrNull()

        when(option) {
            0 -> taskManager.listTasks()
            1 -> {
                print("Titulo da task: ")
                val title = readlnOrNull().toString()
                print("descrição da task: ")
                val description = readlnOrNull().toString()

                val taskCriada = taskManager.createTask(title = title, description = description)

                println("A tarefa #${taskCriada.id} foi criada com sucesso")
            }
            2 -> println("Aqui deve ATUALIZAR")
            3 -> {
                println("aqui deve DELETAR")
            }
            4 -> {println("aqui deve BUSCAR")}
            5 -> {println("Aplicação encerrada.")}
        }
//        println("Nome da tarefa")
//        val titleTask = readlnOrNull().toString()
//
//        println("Descrição da tarefa")
//        val descriptionTask = readlnOrNull().toString()
//
//        taskManager.createTask(titleTask, descriptionTask)
//
//        println("a classe foi criada")


    }
}