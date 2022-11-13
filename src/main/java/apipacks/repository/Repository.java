package apipacks.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import apipacks.model.People;

public interface Repository extends CrudRepository<People, Integer> {

	List<People> findAll();

	People findByCodigo(int codigo);

	List<People> findByOrderByName();

	// List<People> findByOrderByNameAsc();

	// List<People> findByOrderByNameDesc();

	// List<People> findByNameOrderByIdadeAsc(String name);

	List<People> findByNameOrderByAge(String String);

	List<People> findByNameContaining(String termo);

	List<People> findByNameStartsWith(String string);

	List<People> findByNameEndsWith(String string);

	

}
