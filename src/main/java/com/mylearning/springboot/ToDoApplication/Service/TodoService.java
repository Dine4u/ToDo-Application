package com.mylearning.springboot.ToDoApplication.Service;

import com.mylearning.springboot.ToDoApplication.Model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>();;
    private static int todoCount=0;

    static {
        todos.add(new Todo(++todoCount,"Dinesh","Learn DSA", LocalDate.now().plusMonths(1),"Completed"));
        todos.add(new Todo(++todoCount,"Dinesh","Learn SQL", LocalDate.now().plusMonths(1),"Completed"));
        todos.add(new Todo(++todoCount,"Dinesh","Learn LLD", LocalDate.now().plusMonths(1),"In Progress"));
    }

    public List<Todo> getTodosAll(){
        return todos;
    }

    public List<Todo> getTodos(String userName) {
        List<Todo> todoList = todos.stream().filter(todo -> todo.getName().equalsIgnoreCase(userName)).toList();
        return todoList;
    }

    public void addTodos(String userName,String description, LocalDate targetDate, String status){
        todos.add(new Todo(++todoCount,userName,description,targetDate,status));
    }

    public void deleteTodos(int id){
        todos.removeIf(todo -> todo.getId()==id);
    }

    public Todo getTodo(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findAny().get();
    }

    public void update(Todo todo) {
        this.deleteTodos(todo.getId());
        todos.add(todo);
    }
}
