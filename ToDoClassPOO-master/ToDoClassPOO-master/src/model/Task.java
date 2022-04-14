package model;

import java.time.LocalDate;

public class Task { /*Representação da tarefa que irá ser realizada*/

    private static int contador;

    private int idTask;
    private String description;
    private boolean isDone;
    private LocalDate deadLine;

    public Task(String description, LocalDate deadLine){ /*Construtor da Tarefa*/
        Task.contador++;
        this.idTask = Task.contador;
        this.description = description;
        this.isDone = false;
        this.deadLine = deadLine;
    }
    /*Getters e Setters*/
    public int getIdTask() {
        return idTask;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public void doneTask(){
        this.isDone = true;
    }

    @Override
    public String toString() { /*Conversão das informações para String dentro do Objeto para fácil extração*/
        return "Task{" +
                "idTask=" + idTask +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                ", deadLine=" + deadLine +
                '}';
    }
}
