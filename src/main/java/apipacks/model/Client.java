package apipacks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;

	@NotBlank(message = "insert a name")
	private String name;
	
	@NotBlank(message = "insert a age")
	private int age;
	
	//fico buraco nao ta validando o @
	@NotBlank
	@Email(message = "insert the valid email")
	private String email;

}
