package com.mylearning.springboot.ToDoApplication.Repository;

import com.mylearning.springboot.ToDoApplication.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<Todo,Integer> {

    List<Todo> findAllByName(String userName);
}
