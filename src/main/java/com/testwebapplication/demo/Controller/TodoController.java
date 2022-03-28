package com.testwebapplication.demo.Controller;

import com.testwebapplication.demo.Model.Todo;
import com.testwebapplication.demo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController
{

	@Autowired
	TodoService service;

	//    @InitBinder
	//    public void initBinder(WebDataBinder binder){
	//        //Date - dd/MM/YYYY
	//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	//    }

	private String getLoggedInUsername(Model model)
	{
		return (String) model.getAttribute( "name" );
	}

	@GetMapping("/list-todos")
	public String showTodosList(Model model)
	{
		String name = getLoggedInUsername( model );
		model.addAttribute( "todos", service.retrieveTodos( name ) );
		return "list-todos";
	}

	@GetMapping("/add-todo")
	public String showAddTodoPage(Model model)
	{
		model.addAttribute( "todo", new Todo( getLoggedInUsername( model ), "Default desc", false ) );
		return "todo";
	}

	@PostMapping("/add-todo")
	public String addTodo(Model model, @RequestParam String desc)
	{
		service.addTodo( getLoggedInUsername( model ), desc, false );
		return "redirect:/list-todos";
	}

	@GetMapping("/delete-todos")
	public String deleteTodo(@RequestParam int id)
	{
		service.deleteTodo( id );
		return "redirect:/list-todos";
	}

	@GetMapping("/update-todos")
	public String updateTodo(@RequestParam int id, Model model)
	{ //
		Todo retrievedTodo = service.retrieveTodo( id );
		model.addAttribute( "todo", retrievedTodo );
		return "updateTodo";
	}

	@PostMapping("/update-todos")
	public String updateTodo(Todo todo, @RequestParam int id)
	{
		service.updateTodo( todo );
		return "redirect:/list-todos";
	}

}
