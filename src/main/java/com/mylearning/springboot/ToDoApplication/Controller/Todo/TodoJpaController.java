package com.mylearning.springboot.ToDoApplication.Controller.Todo;

import com.mylearning.springboot.ToDoApplication.Model.Todo;
import com.mylearning.springboot.ToDoApplication.Service.TodoJpaService;
import com.mylearning.springboot.ToDoApplication.Service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoJpaController {
    private TodoJpaService todoJpaService;

    @Autowired
    public TodoJpaController(TodoJpaService todoJpaService){
        this.todoJpaService=todoJpaService;
    }

    //todoAll.jsp yet to implement
//    @RequestMapping("/todo-listAll")
//    public String getTodoListAll(ModelMap modelMap){
//        List<Todo> todos=todoService.getTodosAll();
//        modelMap.addAttribute("todosAll",todos); //checks for null in attribute name, attributes name cannot be null
//
////        modelMap.addAttribute(null,todos);//Error
////        modelMap.put("todos",todos);//similar to addattribute() method, but attributes name can be null
//        return "todosAll";
//    }

    @RequestMapping("/todo-list")
    public String getTodoList(ModelMap modelMap){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Todo> todos=todoJpaService.getTodos(userName);
        modelMap.addAttribute("todos",todos); //checks for null in attribute name, attributes name cannot be null

//        modelMap.addAttribute(null,todos);//Error
//        modelMap.put("todos",todos);//similar to addattribute() method, but attributes name can be null
        return "todos";
    }


    @RequestMapping("/add-todo")
    public String getAddTodoPage(ModelMap modelMap){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Todo todo=new Todo(0,userName,"", LocalDate.now(),"Created");
//        modelMap.addAttribute("todo",todo);
        modelMap.put("todo",todo);
        return "addToDo";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String addTodo(ModelMap modelMap, @Valid @ModelAttribute("todo") Todo todo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream().forEach(System.out::println);
            return "addToDo";
        }
        String userName = (String)modelMap.get("name");
        todoJpaService.addTodos(userName,todo.getDescription(),todo.getTargetDate(),todo.getStatus());
        return "redirect:todo-list";
    }

    @RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoJpaService.deleteTodos(id);
        return "redirect:todo-list";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
    public String updateTodoPage(@RequestParam int id,ModelMap modelMap){
        Todo todo = todoJpaService.getTodo(id);
        modelMap.put("todo",todo);
        return "addToDo";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid @ModelAttribute("todo") Todo todo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream().forEach(System.out::println);
            return "addToDo";
        }
        todoJpaService.update(todo);
        return "redirect:todo-list";
    }
}
