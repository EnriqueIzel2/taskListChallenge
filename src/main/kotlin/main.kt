fun main () {
    var option: Int? = 0

    val taskManager = TaskManager()

    while (option != 5) {

        println(
            """
        +---------------------------------+
        |  CONTROLE DE TAREFAS            |
        +---------------------------------+
        |  0 - Listar Tarefas             |
        |  1 - Adicionar                  |
        |  2 - Atualizar                  |
        |  3 - Deletar                    |
        |  4 - Buscar                     |
        |  5 - Sair                       |
        |  6 - Total de Tarefas           |
        |  7 - Finalizar Tarefas          |
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
            2 -> {
                // atualizar
                println("Insira o ID da atividade que deseja atualizar")
                val id = readlnOrNull()?.toIntOrNull()
                val taskToUpdate = taskManager.getTask(id!!)

                taskToUpdate.let {
                    println("O nome atual da atividade é ${taskToUpdate?.title}")
                    println("Insira o nome atualizado (se não quiser alterar, tecle ENTER)")
                    val title: String? = readlnOrNull().toString()

                    println("A descrição atual da atividade é ${taskToUpdate?.description}")
                    println("Insira a descrição atualizada (se não quiser alterar, tecle ENTER)")
                    val description: String? = readlnOrNull().toString()

                    if (title != null || description != null) {
                        taskManager.update(Task(
                            id = taskToUpdate!!.id,
                            title = title!!,
                            description = description!!,
                            isCompleted = taskToUpdate.isCompleted,
                            createdAt = taskToUpdate.createdAt,
                        ))
                    } else {
                        println("Nada foi atualizado")
                    }

                }
            }
            3 -> {
                // deletar
                println("Insira o ID da atividade para exclui-la:")
                val id = readlnOrNull()?.toIntOrNull()
                val isDeleted = taskManager.delete(id!!)

                if (isDeleted) println("Deletado com sucesso") else println("Falha ao deletar")
            }
            4 -> {
                // aqui deve buscar por ID
                println("Insira o ID da atividade para buscá-la:")
                val id = readlnOrNull()?.toIntOrNull()
                val task = taskManager.getTask(id!!)

                println("Task ${id} encontrada")
                println(
                    """
                    ID: ${task?.id}
                    TITLE: ${task?.title}
                    DESCRIPTION: ${task?.description}
                    STATUS: ${task?.isCompleted}
                    """
                )
            }
            5 -> { println("Aplicação encerrada.") }
            6 -> { println("O total de tarefas é: ${taskManager.countTasks()}") }
            7 -> {
                // atualiza o status da tarefa
                println("Insira o ID da atividade que deseja finalizar")
                val id = readlnOrNull()?.toIntOrNull()
                if (id == null) {
                    println("O ID é inválido")
                    return
                }

                val taskToFinish = taskManager.getTask(id) ?: run {
                    println("Tarefa não encontrada")
                    return
                }

                val taskUpdated = taskToFinish.copy(
                    isCompleted = true
                )

                taskManager.update(taskUpdated)
                println("Tarefa concluída com sucesso")
            }
        }
    }
}