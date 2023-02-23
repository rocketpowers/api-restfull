package apipacks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Peoples {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;

	private String name;

	private int age;

}
