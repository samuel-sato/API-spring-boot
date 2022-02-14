package one.digitalInovation.personAPI.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String cpf;


	private LocalDate birthDate;

	private Long departmentID;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Phone> phones;
	
	

}
