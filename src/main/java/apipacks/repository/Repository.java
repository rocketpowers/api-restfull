package apipacks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import apipacks.model.Peoples;

public interface Repository extends CrudRepository<Peoples, Integer> {

	List<Peoples> findAll();

	Peoples findByCode(int code);

	List<Peoples> findByOrderByName();

	// List<People> findByOrderByNameAsc();

	// List<People> findByOrderByNameDesc();

	// List<People> findByNameOrderByIdadeAsc(String name);

	List<Peoples> findByNameOrderByAge(String String);

	List<Peoples> findByNameContaining(String termo);

	List<Peoples> findByNameStartsWith(String string);

	List<Peoples> findByNameEndsWith(String string);

	@Query(value = "SELECT SUM(age) FROM peoples", nativeQuery = true)
	int somaIdades();

	@Query(value = "SELECT * FROM peoples WHERE age >= :age", nativeQuery = true)
	List<Peoples> ageOlderOrEqual(int age);

	int countBycode(int code);
	
	
}











