package apipacks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import apipacks.model.People;

@RestController
public class Controller {

	
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
