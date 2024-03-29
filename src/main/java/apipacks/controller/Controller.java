package apipacks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import apipacks.model.Client;
import apipacks.model.Peoples;
import apipacks.repository.Repository;
import apipacks.services.Service;

@RestController
public class Controller {

	@Autowired
	private Repository action;

	@Autowired
	private Service service;

	//@PutMapping("/api")
	//public Peoples edit(@RequestBody Peoples obj) {
		//return action.save(obj);
	
	@PutMapping("/api")
	public ResponseEntity<?> edit(@RequestBody Peoples obj) {
		return service.edit(obj);

	}

	@DeleteMapping("/api/{code}")
	public ResponseEntity<?> remove(@PathVariable int code) {
		return service.remove(code);

	}


	@GetMapping("/api/orderName")
	public List<Peoples> orderNames() {
		return action.findByOrderByName();
		// return action.findByOrderByNameAsc();
		// return action.findByOrderByNameDesc();

	}

	@GetMapping("/api/orderName2")
	public List<Peoples> orderName2() {
		return action.findByNameOrderByAge("mike");

	}

	@GetMapping("/api/account")
	public long account() {
		return action.count();

	}

	@GetMapping("/api")
	public List<Peoples> select() {
		return action.findAll();

	}
//	@GetMapping("/api")
//	public ResponseEntity<?> select() {
//		return service.select();

	@GetMapping("/api/{codigo}")
	public Peoples selectForCod(@PathVariable int codigo) {
		return action.findByCode(codigo);
	}

//	@GetMapping("/api/{code}")
//	public ResponseEntity<?> selectForCode(@PathVariable int code) {
//		return service.selectForCode(code);
//
//	}

	
	@PostMapping("/api")
	// public Peoples register(@RequestBody Peoples obj) {
	// return action.save(obj);
	public ResponseEntity<?> register( @RequestBody @Valid Peoples obj) {
		return service.register(obj);
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
	public Peoples people(@RequestBody @Valid Peoples p) {
		return p;

	}

	@GetMapping("/api/haveName")
	public List<Peoples> haveName() {
		return action.findByNameContaining("a"); // letters or names
	}

	@GetMapping("/api/startsWith")
	public List<Peoples> startsWith() {
		return action.findByNameStartsWith("a");
	}

	@GetMapping("/api/endsWith")
	public List<Peoples> endsWith() {
		return action.findByNameEndsWith("e");
	}

	@GetMapping("/api/sumAge")
	public int sumAge() {
		return action.somaIdades();
	}

	@GetMapping("/api/age")
	public List<Peoples> ageOlderOrEqual() {
		return action.ageOlderOrEqual(57);
	}

	@GetMapping("/status")
	public ResponseEntity<?> status() {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/client")
	public void client( @RequestBody @Valid Client obj) {
		
	}
}
