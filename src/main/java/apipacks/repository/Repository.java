package apipacks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import apipacks.model.Peoples;

public interface Repository extends CrudRepository<Peoples, Integer> {

	List<Peoples> findAll();

	Peoples findByCodigo(int codigo);

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

}
