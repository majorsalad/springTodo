package com.testwebapplication.demo.Service;

import com.testwebapplication.demo.Model.Todo;
import com.testwebapplication.demo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;
    @Autowired
    private TodoRepository todoRepo;

    static {
        todos.add(new Todo("in28Minutes", "Learn Spring MVC",
                false));
        todos.add(new Todo("in28Minutes", "Learn Struts", false));
        todos.add(new Todo("in28Minutes", "Learn Hibernate",
                false));
    }

    public List<Todo> retrieveTodos(String user) {
//        List<Todo> filteredTodos = new ArrayList<Todo>();
        List<Todo> emptyList = new ArrayList<>();
//        for (Todo todo : todos) {
//            if (todo.getUser().equals(user)) {
//                filteredTodos.add(todo);
//            }
//        }

        return todoRepo.findByUser( user ) == null ? null : todoRepo.findByUser( user );
        // return filteredTodos;
    }

    public void   addTodo(String name, String desc,
                        boolean isDone) {
        Todo addedTodo = new Todo( name, desc, isDone );
        todoRepo.save( addedTodo );
//        todos.add(new Todo(name, desc, targetDate, isDone));
    }

    public Todo retrieveTodo(int id){
//        for(Todo todo : todos){
//            if(todo.getId() == id){
//                return todo;
//            }
//        }
//        return null;
        return todoRepo.getById( id );
    }

    public void updateTodo(Todo todo){ //int id, String user, String newDesc
        deleteTodo( todo.getId() );
        todoRepo.save(todo);
//        todos.remove(todo);
//        todos.add(todo);
    }

    public void deleteTodo(int id) {
        todoRepo.deleteById( id );
//        Iterator<Todo> iterator = todos.iterator();
//        while (iterator.hasNext()) {
//            Todo todo = iterator.next();
//            if (todo.getId() == id) {
//                iterator.remove();
//            }
//        }
    }
}
