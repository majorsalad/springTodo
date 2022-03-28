package com.testwebapplication.demo.Repository;

import com.testwebapplication.demo.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer>
{
	// Below are the following operations we do in our TodoService

	// retrieveTodos(name): Since there's no support for retrieving todos by name, we have to specify that functionality ourselves. What we are extending from the JPARepo has
	// something called a QueryFacility. So, all we need to define is how we would want to query for this. When you're using Spring JPA, you simply can write "findBy" and append
	// the DO's column name. The field we're using to search is called "User." So, "findByUser" would accomplish the retrieveTodosByName we're looking for
	List<Todo> findByUser(String user);

	//These 4 are already provided by the JPA Repository
	// deleteTodo(id): just used deleteById(id) in the service layer

	// retrieveTodo(id):

	// updateTodo(to do):

	// addTodo : check the service. Just used todoRepo.save(addedTodo)

}
