package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	private Integer age;

	@Column(nullable = false, unique = true)
	private int rollno;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Marks marks;
}
