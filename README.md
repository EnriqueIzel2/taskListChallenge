# Desafio Prático - Task List
Desafio de Kotlin do curso de Android na Rocketseat

## Descrição
O desafio consiste em criar uma aplicação que represente
uma "Lista de tarefas".

## Requisitos
* Utilize companion object para gerar IDs únicos automaticamente para cada Task.
* Implemente uma classe TaskManager com métodos para:
* Adicionar uma nova tarefa.
* Listar todas as tarefas (destruturando title e isCompleted).
* Buscar uma tarefa por ID.
* Atualizar o status (isCompleted) de uma tarefa específica.
* Excluir uma tarefa pelo ID.
* Filtrar tarefas concluídas ou pendentes usando filter.
* Use funções de validação como require para garantir que o título da tarefa não está vazio e a tarefa existe antes de tentarmos excluir ou atualiza-lá.
* Utilize sealed classes para representar o retorno das operações com os estados de sucesso (com uma mensagem personalizada) e erro (com uma mensagem de erro).
* Adicione funções para converter a task em uma string formatada, e obter a contagem de tarefas diretamente da lista.
