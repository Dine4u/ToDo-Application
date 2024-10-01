package com.mylearning.springboot.ToDoApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "todos")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    @Size(min = 10,message = "Enter minimum 10 letters")
    private String description;
    @NotNull(message = "Please provide target date")
    @Future(message = "Please select future dates")
    private LocalDate targetDate;
    private String status;

    public Todo(int id, String name, String description, LocalDate targetDate, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Todo(String name, String description, LocalDate targetDate, String status) {
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    public Todo() {

    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", status='" + status + '\'' +
                '}';
    }
}
