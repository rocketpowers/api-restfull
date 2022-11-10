package apipacks.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import apipacks.model.People;


public interface Repository extends CrudRepository<People, Integer> {
	
	
	List<People> findAll();
	
	

}
