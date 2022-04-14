import controller.TaskController;
import model.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main { /*Classe pricipal que rodará o programa*/

    private static TaskController controller = new TaskController();

    public static void main(String[] args) { /*Método principal, referente ao contato com o usuário.*/
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        while (choose != 7) {
            System.out.println("================ TO DO LIST ================= \n" +
                    "============================================= \n" +
                    "====    1. Criar uma tarefa              ==== \n" +
                    "====    2. Listar as tarefas             ==== \n" +
                    "====    3. Procurar uma tarefa           ==== \n" +
                    "====    4. Editar uma tarefa             ==== \n" +
                    "====    5. Concluir uma tarefa           ==== \n" +
                    "====    6. Deletar uma tarefa            ==== \n" +
                    "====    7. Fechar o programa             ==== \n" +
                    "============================================= \n");
            while (!scanner.hasNext()) ;
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    Main.createTask(scanner);
                    break;
                case 2:
                    Main.listTask(scanner);
                    break;
                case 3:
                    Main.findTask(scanner);
                    break;
                case 4:
                    Main.updateTask(scanner);
                    break;
                case 5:
                    Main.doneTask(scanner);
                    break;
                case 6:
                    Main.deleteTask(scanner);
                    break;
            }
        }
    }

    private static void createTask(Scanner scanner){ /*Método que irá criar uma tarefa*/
        scanner.nextLine();
        System.out.println("====    Insira a descrição da tarefa:    ====");
        String description = scanner.nextLine();
        System.out.println("====   Insira a data limite(AAAA-MM-DD): ====");
        String limitDate = scanner.next();
        Task newTask = Main.controller.createTask(description, LocalDate.parse(limitDate));
        System.out.println(newTask);
    }

    private static void listTask(Scanner scanner){ /*Método que irá exibir a Lista de Tarefa*/
        List<Task> list = Main.controller.listTask();
        list.forEach(task -> System.out.println(task));
    }

    private static void findTask(Scanner scanner){ /*Método que irá procurar a tarefa de acordo com o ID digitado*/
        System.out.println("====       Insira o ID da tarefa:        ====");
        int id = scanner.nextInt();
        Task task = Main.controller.findTask(id);
        System.out.println(task);
    }

    private static void updateTask(Scanner scanner){ /*Método que irá atualizar/editar a tarefa*/
        System.out.println("====       Coloque o ID da tarefa:        ====");
        int updateId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("====    Insira a descrição da tarefa:    ====");
        String description = scanner.nextLine();
        System.out.println("====   Insira a data limite(AAAA-MM-DD): ====");
        String limitDate = scanner.next();
        Task updateTask = Main.controller.updateTask(description, limitDate, updateId);
        System.out.println(updateTask);
    }

    private static void doneTask(Scanner scanner){ /*Método que irá retornar ao úsiário se a tarefa foi concluída ou não*/
        System.out.println("====       Insira o ID da tarefa:        ====");
        int id = scanner.nextInt();
        Main.controller.doneTask(id);
        System.out.println("====         Tarefa Finalizada!!         ====");
    }

    private static void deleteTask(Scanner scanner){ /*Método que irá excluir a tarefa*/
        System.out.println("====       Insira o ID da tarefa:        ====");
        int id = scanner.nextInt();
        Main.controller.deleteTask(id);
        System.out.println("====          Tarefa Deletada!!          ====");
    }

}