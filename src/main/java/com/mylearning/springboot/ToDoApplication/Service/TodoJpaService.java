package com.mylearning.springboot.ToDoApplication.Service;

import com.mylearning.springboot.ToDoApplication.Model.Todo;
import com.mylearning.springboot.ToDoApplication.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoJpaService {

    private ToDoRepository toDoRepository;

    @Autowired
    public TodoJpaService(ToDoRepository toDoRepository){
        this.toDoRepository=toDoRepository;
    }
    public List<Todo> getTodos(String userName) {
        return toDoRepository.findAllByName(userName);
    }

    public void addTodos(String userName, String description, LocalDate targetDate, String status) {
        Todo todo = new Todo(userName, description, targetDate, status);
        toDoRepository.save(todo);
    }

    public void deleteTodos(int id) {
        toDoRepository.deleteById(id);
    }

    public Todo getTodo(int id) {
        return toDoRepository.findById(id).get();
    }

    public void update(Todo todo) {
        toDoRepository.save(todo);
    }
}
