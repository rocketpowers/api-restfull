package apipacks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/welcome/{nome}")
	public String welcome(@PathVariable String nome) {
		return "welcome  " + nome;
	}

	@PostMapping("/people")
	public People people(@RequestBody People p) {
		return p;

	}
}
