package apipacks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import apipacks.model.People;
import apipacks.repository.Repository;

@RestController
public class Controller {

	@Autowired
	private Repository action;

	@PutMapping("/api")
	public People edit(@RequestBody People obj) {
		return action.save(obj);

	}

	@DeleteMapping("/api/{codigo}")
	public void remove(@PathVariable int codigo) {
		People obj = selectForCod(codigo);
		action.delete(obj);
	}
	
	@GetMapping("/api/orderName")
	public List<People> orderNames(){
		return action.findByOrderByName();
	}
	
	
	@GetMapping("/api/account")
	public long account() {
		return action.count();
		
	}

	@GetMapping("/api")
	public List<People> select() {
		return action.findAll();
	}

	@GetMapping("/api/{codigo}")
	public People selectForCod(@PathVariable int codigo) {
		return action.findByCodigo(codigo);
	}

	@PostMapping("/api")
	public People register(@RequestBody People obj) {
		return action.save(obj);
	}

	@GetMapping("")
	public String mensagem() {
		return "hello word";
	}

	@GetMapping("/welcome/{name}")
	public String welcome(@PathVariable String name) {
		return "welcome  " + name;
	}

	@PostMapping("/people")
	public People people(@RequestBody People p) {
		return p;

	}
}
