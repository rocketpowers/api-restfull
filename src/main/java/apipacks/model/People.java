package apipacks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Pessoas")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	private String nome;

	private String idade;

}
